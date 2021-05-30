package hackerRank.Token;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string_data =scan.nextLine();
        if (string_data.trim().length()==0 || string_data.trim().length()>400000)
        {
            System.out.println(0);
            return;
        }

        String array[] =string_data.trim().split("[ !,?.\\_'@]+");
        System.out.println(array.length);
        for (String word:array)
            System.out.println(word);

    }
}
