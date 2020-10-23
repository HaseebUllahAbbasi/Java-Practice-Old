   public static class ByteValues
      {
        public static Dictionary<byte, string> ByteDictionary;

        public static void AddValues(byte b, string values)
         {
          if (ByteDictionary == null)
          {
          ByteDictionary = new Dictionary<byte, string>();
           }

      ByteDictionary.Add(b, values);
        }

  public static List<List<T>> Split<T>(this List<T> list, int parts)
  {
      int i = 0;
      var splits = from item in list
                   group item by i++ % parts into part
                   select part.ToList();
      return splits.ToList();
  }
}


    public class Node
    {
    public byte value;
    public long freq;
    public Node LeftNode;
    public Node RightNode;

    public void Traverse(string path)
    {
        if (LeftNode == null)
        {
            ByteValues.AddValues(value, path);
        }
        else
        {

            LeftNode.Traverse(path + "0");
            RightNode.Traverse(path + "1");
        }
    }

}

   public partial class MainWindow : Window
{
    Dictionary<byte, long> Bytefreq = new Dictionary<byte, long>();
    string filename;
    List<Node> Nodes = new List<Node>();

    public MainWindow()
    {
        InitializeComponent();
    }

    private void Button_Click_1(object sender, RoutedEventArgs e)
    {

        OpenFileDialog dialog = new OpenFileDialog();
        dialog.ShowDialog();
        filename = dialog.FileName;
        if (!string.IsNullOrEmpty(filename))
        {
            for (int i = 0; i <= byte.MaxValue; i++)
            {
                Bytefreq.Add((byte)i, 0);
            }
            BackgroundWorker worker = new BackgroundWorker();
            worker.WorkerReportsProgress = true;
            worker.DoWork += worker_DoWork;
            worker.ProgressChanged += worker_ProgressChanged;
            worker.RunWorkerCompleted += worker_RunWorkerCompleted;
            worker.RunWorkerAsync();

        }
    }


    void worker_DoWork(object sender, DoWorkEventArgs e)
    {
        BackgroundWorker worker = sender as BackgroundWorker;
        using (BinaryReader reader = new BinaryReader(File.OpenRead(filename)))
        {
            long length = reader.BaseStream.Length;
            int pos = 0;
            System.Windows.Application.Current.Dispatcher.Invoke(() =>
            {
                pbProgress.Maximum = length;
            });

            while (pos < length)
            {
                byte[] inputbytes = reader.ReadBytes(1000000);
                Bytefreq = inputbytes.OrderBy(x => x).GroupBy(x => x).ToDictionary(x => x.Key, x => (long)(Bytefreq[x.Key] + x.Select(l => l).ToList().Count));
                pos = pos + inputbytes.Length;
                worker.ReportProgress(pos);
            }
        }

    }
    void worker_ProgressChanged(object sender, ProgressChangedEventArgs e)
    {
        pbProgress.Value = e.ProgressPercentage;
    }



    void worker1_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)
    {
        System.Windows.MessageBox.Show("DONE");
        System.Windows.Application.Current.Shutdown();
    }
    void worker_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)
    {
        pbProgress.Value = 0;
        foreach (KeyValuePair<byte, long> kv in Bytefreq)
        {
            Nodes.Add(new Node() { value = kv.Key, freq = kv.Value });
        }

        while (Nodes.Count > 1)
        {
            Nodes = Nodes.OrderBy(x => x.freq).ThenBy(x => x.value).ToList();
            Node left = Nodes[0];
            Node right = Nodes[1];

            Node newnode = new Node() { LeftNode = left, RightNode = right, freq = left.freq + right.freq };
            Nodes.Remove(left);
            Nodes.Remove(right);
            Nodes.Add(newnode);
        }

        Nodes[0].Traverse(string.Empty);

        BackgroundWorker worker1 = new BackgroundWorker();
        worker1.WorkerReportsProgress = true;
        worker1.DoWork += worker1_DoWork;
        worker1.ProgressChanged += worker_ProgressChanged;
        worker1.RunWorkerCompleted += worker1_RunWorkerCompleted;
        worker1.RunWorkerAsync();

    }
    void worker1_DoWork(object sender, DoWorkEventArgs e)
    {
        BackgroundWorker worker = sender as BackgroundWorker;
        Dictionary<byte, string> bytelookup = ByteValues.ByteDictionary;
        using (BinaryWriter writer = new BinaryWriter(File.Create(Environment.GetFolderPath(Environment.SpecialFolder.Desktop) + "\\Test.txt")))
        {
            using (BinaryReader reader = new BinaryReader(File.OpenRead(filename)))
            {
                long length = reader.BaseStream.Length;
                int pos = 0;

                while (pos < length)
                {

                    byte[] inputbytes = reader.ReadBytes(1000000);
                    StringBuilder builder = new StringBuilder();
                    List<string> outputbytelist = inputbytes.Select(b => bytelookup[b]).ToList();

                    outputbytelist.ForEach(x => builder.Append(x));

                    int numOfBytes = builder.ToString().Length / 8;
                    var bytesAsStrings =  builder.ToString().Select((c, i) => new { Char = c, Index = i })
                                                            .GroupBy(x => x.Index / 8)
                                                            .Select(g => new string(g.Select(x => x.Char).ToArray()));
                     byte[] finalbytes = bytesAsStrings.Select(s => Convert.ToByte(s, 2)).ToArray();
                     writer.BaseStream.Write(finalbytes, 0, finalbytes.Length);
                    pos = pos + inputbytes.Length;
                    worker.ReportProgress(pos);
                }
            }
        }
    }


}