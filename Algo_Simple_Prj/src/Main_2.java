import java.util.ArrayList;
import java.util.Scanner;

public class Main_2
{
    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);
        ArrayList<Pizza> list = new ArrayList<>();
        int select = 1;
        while (select!=4){
            System.out.println("1. for small, 2. for medium, 3. for large 4. Exit");
            System.out.println("Enter your choice: ");
            int beef;
            int chicken;
            int cheese;

            select = input.nextInt();
            switch (select)
            {
                case 1:
                    System.out.println("Please enter the number of Beef toppings :");
                     beef = input.nextInt();
                    System.out.println("Please enter the number of Chicken toppings :");
                     chicken = input.nextInt();
                    System.out.println("Please enter the number of Cheese toppings :");
                     cheese = input.nextInt();
                    list.add(new Pizza("small",cheese,beef,chicken ));
                    break;
                case 2:
                    System.out.println("Please enter the number of Beef toppings :");
                     beef = input.nextInt();
                    System.out.println("Please enter the number of Chicken toppings :");
                     chicken = input.nextInt();
                    System.out.println("Please enter the number of Cheese toppings :");
                     cheese = input.nextInt();
                    list.add(new Pizza("medium",cheese,beef,chicken ));
                    break;
                case 3:
                    System.out.println("Please enter the number of Beef toppings :");
                    beef = input.nextInt();
                    System.out.println("Please enter the number of Chicken toppings :");
                    chicken = input.nextInt();
                    System.out.println("Please enter the number of Cheese toppings :");
                    cheese = input.nextInt();
                    list.add(new Pizza("large",cheese,beef,chicken ));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please enter the given key");
                    break;
            }
        }
        System.out.println("Order description:");
        System.out.println("***************************************************************************");
        int totol_amount = 0;
        for (Pizza obj:list)
        {
            totol_amount+=obj.calcCost();
            System.out.println(obj.getDescription());
        }
        System.out.println("***************************************************************************");

        System.out.println("The Price is: "+totol_amount+" The Tax 2% : "+(2.0/totol_amount));
        System.out.println("The Total amount is "+(totol_amount+(2.0/totol_amount)));
        System.out.println("***************************************************************************");
    }
}