import java.util.Scanner;

public class Encrypt
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String message =  input.nextLine();
        int increment = input.nextInt();
        System.out.println("before enc "+message);
        message = encrypt(message.toUpperCase(),increment);
        System.out.println("after enc "+message+"\n now dec ");
        decrypt(message);
    }
    public static String encrypt(String line,int inc)
    {
        char[] array =  line.toCharArray();
        for (int i=0; i< array.length; i++)
        {
            if((int)array[i]+inc<=90 && (int)array[i]>=65&&(int)array[i]<=90)
            {
                array[i] = (char)((int)array[i]+inc);
            }
            else if((int)array[i]>=65&&(int)array[i]<=90)
            {
                array[i] = (char)(((int)array[i]+inc)-26);
            }
            else
                array[i] = array[i];
        }
        return new String(array);
    }
    public static void decrypt(String line)
    {
        for(int i=1; i<=26; i++)
        {
            for(int j=0; j<line.length(); j++)
            {
                if((int)(line.charAt(j)-i)>=65 && (int)line.charAt(j)>=65&&(int)line.charAt(j)<=90)
                {
                    System.out.print((char)((int)line.charAt(j)-i));
                }
                else if((int)(line.charAt(j)-i) < 65 && (int)line.charAt(j)>=65&&(int)line.charAt(j)<=90)
                {
                    System.out.print((char)((int)line.charAt(j)+26-i));
                    //System.out.print((int)(line.charAt(j)-i));

                }
                else
                    System.out.print(line.charAt(j));
            }
            System.out.println();
        }
    }
}
