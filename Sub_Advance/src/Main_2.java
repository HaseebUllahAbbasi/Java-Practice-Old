import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner(System.in);
        String regularExpr = "(\\d+)\\t\\t(\\w+)(\\s+)(\\D+)(\\d+)( )(\\w+)(\\s+)(\\d+.\\d+)";

        File file = new File("products.txt");
        Scanner file_reader  = new Scanner(file);
        ArrayList<Product> products = new ArrayList();
        while (file_reader.hasNext())
        {
            String myString =  file_reader.nextLine();
//            Pattern pattern = Pattern.compile(regularExpr);
            Pattern pattern = Pattern.compile("(\\d{7})\\s+((?:\\S+\\s)+)\\s+((?:\\S+\\s)+)\\s+(\\d+\\s\\w+)\\s+(\\d+(?:\\.\\d+)?)");

            Matcher m = pattern.matcher(myString);
            if(m.find())
            {

                Product product =  new Product(m.group(1),m.group(2),m.group(4),Double.parseDouble(m.group(5)));

                products.add(product);

            }
        }
        Cart cart = new Cart();

        String ask = "a";
        while(!ask.equals("q") && !ask.equals("Q"))
        {
            System.out.println("\nPlease Enter the SKU Number");
            String sku = input.nextLine();
            Product result =  products.stream().filter(prod -> sku.equals(prod.getSKU())).findFirst().orElse(null);
            if(result==null)
            {
                System.out.println("SKU is not Found ,Invalid Product");
            }
            else
            {
                cart.addProduct(result);
                System.out.println("Item Added\n\n");
            }
            System.out.println("Enter any key to Continue ");
            System.out.println("Enter any Q to End Shopping ");
            ask = input.nextLine();

        }
        System.out.println("Grand Total: $"+ cart.getTransactionTotal());
        Scanner number_input  = new Scanner(System.in);
        double total = 0;
        System.out.println("Please enter the Payment");
        double  payment =  number_input.nextDouble();
        total+=payment;
        while (total<cart.getTransactionTotal())
        {
            System.out.println("Insufficient Amount ");
            System.out.println("Current Balance : $"+(cart.getTransactionTotal()-total));

            payment =  number_input.nextDouble();
            total+=payment;
        }
        System.out.println("here is your payment");
        System.out.println("******************************************");



        System.out.println(cart);
        System.out.println("\n\n\n");
        System.out.println("Grand Total: $"+ cart.getTransactionTotal());
        System.out.println("Payment :$"+total);
        System.out.println("Change :$"+ (total -  cart.getTransactionTotal()));

        System.out.println("Thank you for Shopping With Us ");
        System.out.println("See You Soon");

        TextWrite.WriteFile(cart,total);
    }
}



