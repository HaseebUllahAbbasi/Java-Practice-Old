import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CodeTree
{
    String bits;
    PriorityQueue<Node> preQue;
    Map<Character, Integer> freq;
    static Map<Character, String> codes;
    static StringBuilder compressed_string;
    Node root;
    CodeTree(String message) throws IOException
    {
        bits = "";
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0 ; i < message.length(); i++) {
            if (!freq.containsKey(message.charAt(i)))
            {
                freq.put(message.charAt(i), 0);
            }
            freq.put(message.charAt(i), freq.get(message.charAt(i)) + 1);
        }

        preQue = new PriorityQueue<>((l, r) -> l.freq - r.freq);

        for (Map.Entry<Character, Integer> entry : freq.entrySet())
        {
            preQue.add(new Node(entry.getKey(), entry.getValue()));
        }
        while (preQue.size() != 1)
        {
            Node left = preQue.poll();
            Node right = preQue.poll();

            int sum = left.freq + right.freq;
            preQue.add(new Node('\0', sum, left, right));
        }
        Node root = preQue.peek();

        codes = new HashMap<>();
        encode(root, "", codes);

        FileOutputStream fileOutputStream = new FileOutputStream("codes.txt");
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            String codes =(entry.getKey() + " " + entry.getValue()+"\n");
            byte code[] = codes.getBytes();
            fileOutputStream.write(code);
        }
        fileOutputStream.close();
        compress(message);
    }
    public  String decode(String bits, Map<Character, String> codes)
    {
        int index = -1;
        System.out.println("\nDecoded string is: \n");
        while (index < compressed_string.length() - 2) {
            index = decode(root, index, compressed_string);
        }
        return "";
    }
    public static void encode(Node root, String str, Map<Character, String> huffmanCode)
    {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, str);
        }
        encode(root.left, str + "0", huffmanCode);
        encode(root.right, str + "1", huffmanCode);
    }
    public static int decode(Node root, int index, StringBuilder sb)
    {
        if (root == null)
            return index;
        if (root.left == null && root.right == null)
        {
            System.out.print(root.ch);
            return index;
        }
        index++;
        if (sb.charAt(index) == '0')
            index = decode(root.left, index, sb);
        else
            index = decode(root.right, index, sb);

        return index;
    }
    public void compress(String message) throws IOException
    {
        StringBuilder compressed_string = new StringBuilder();
        FileOutputStream fileOutputStream = new FileOutputStream("compressed");
        for (int i = 0 ; i < message.length(); i++)
        {
            compressed_string.append(codes.get(message.charAt(i)));
            String compressed =(codes.get(message.charAt(i)));
            bits += (codes.get(message.charAt(i)));
            byte compressed_byte[] = compressed.getBytes();
            fileOutputStream.write(compressed_byte);
        }
        fileOutputStream.close();
    }
    public static void testCodingTree() throws IOException
    {

        String phrase = "this is a sentence to be tested by the tester for checking the functionality of the code";
        long total_size = phrase.length()*8;

        int character =0;
        String message = "";

        long before_enc = System.currentTimeMillis();
        CodeTree codeTree = new CodeTree(phrase);
        long after_time = System.currentTimeMillis();

        System.out.println("The Total compression process took milliseconds "+(after_time-before_enc));
        File compressed = new File("compressed");
		System.out.print("The Compression ratio is : ");
		System.out.format("%.2f\n", (double)compressed.length()/total_size);
        
        System.out.println("The original file size  is "+total_size+" and the compressed file size  is "+compressed.length());
        System.out.println("the Encoded message is "+codeTree.getbits());
    }
    private  String getbits()
    {
        return bits;
    }
}
class Node
{
    char ch;
    int freq;
    Node left = null, right = null;
    Node(char ch, int freq)
    {
        this.ch = ch;
        this.freq = freq;
    }
    public Node(char ch, int freq, Node left, Node right)
    {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

