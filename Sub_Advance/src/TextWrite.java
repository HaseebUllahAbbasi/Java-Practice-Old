import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextWrite
{
    public static void WriteFile(Cart data, double total) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("receipt.txt");
        printWriter.println(data.toString());

        printWriter.println("Grand Total: $"+ data.getTransactionTotal());
        printWriter.println("Payment :$"+total);
        printWriter.println("Change :$"+ (total -  data.getTransactionTotal()));

        printWriter.println("Thank you for Shopping With Us ");
        printWriter.println("See You Soon");


        printWriter.close();

    }
}
