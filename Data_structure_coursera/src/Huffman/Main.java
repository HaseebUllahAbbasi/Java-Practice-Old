import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{


    	File file = new File("test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        long total_size = file.length()*8;

        int character =0;
        String message = "";
        while ((character=fileInputStream.read())!=-1)
        {
            message+=(char)character;
        }
        long before_enc = System.currentTimeMillis();
        new CodeTree(message);
        long after_time = System.currentTimeMillis();

        System.out.println("The Total compression process took milliseconds "+(after_time-before_enc));
        File compressed = new File("compressed");
        System.out.print("The Compression ratio is : ");
	System.out.format("%.2f\n", (double)compressed.length()/total_size);
        System.out.println("The original file size  was "+total_size+" and the new file size  was "+compressed.length());   
	}

}
