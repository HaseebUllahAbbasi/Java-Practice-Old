import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Assignment2
{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String file_name = input.next();
        FileReader file_reader = new FileReader(file_name);

        int character  = 0;
        while((character=file_reader.read())!=-1)
        {
            System.out.println((char)character);
        }
        //new Assignment2("[ ( { sum + addition } ] ) ] * ( total ) ");
        //new ShiftReduceParse(args[0]);

    }
}
