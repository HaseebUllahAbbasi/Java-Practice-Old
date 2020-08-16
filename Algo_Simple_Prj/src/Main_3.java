import java.util.*;
class pizza implements Comparable<pizza>
{
    private String size;
    private int cheese_toppings;
    private int beef_toppings;
    private int chicken_toppings;
    public pizza(String size,int cheese_toppings,int beef_toppings,int chicken_toppings)
    {
        this.size = size;
        this.cheese_toppings = cheese_toppings;
        this.beef_toppings = beef_toppings;
        this.chicken_toppings = chicken_toppings;
    }
    @Override
    public int compareTo(pizza o) {
        return size.compareTo(o.size);
    }
    public String getDescription()
    {
        return "You have ordered: 1 "+size+" Pizza with"+chicken_toppings+" chicken_toppings , "+beef_toppings+", beef_toppings: "+chicken_toppings+" cheese_toppings : "
                +" and Pizza Cost "+calcCost();
    }
    public int calcCost()
    {
        int total_amount = 0;
        if(size.equals("small")){
            total_amount+=10;
            int  total_toppings = beef_toppings+cheese_toppings+chicken_toppings;
            total_amount = total_amount + total_toppings*2;
        }
        else if(size.equals("medium")){
            total_amount+=12;
            int  total_toppings = beef_toppings+cheese_toppings+chicken_toppings;
            total_amount = total_amount + total_toppings*2;
        }
        else if(size.equals("large")){
            total_amount+=14;
            int  total_toppings = beef_toppings+cheese_toppings+chicken_toppings;
            total_amount = total_amount + total_toppings*2;
        }
        return total_amount;
    }
}
public class Main_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<pizza> queue=new PriorityQueue<pizza>();
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
                    queue.add(new pizza("small",cheese,beef,chicken ));
                    break;
                case 2:
                    System.out.println("Please enter the number of Beef toppings :");
                    beef = input.nextInt();
                    System.out.println("Please enter the number of Chicken toppings :");
                    chicken = input.nextInt();
                    System.out.println("Please enter the number of Cheese toppings :");
                    cheese = input.nextInt();
                    queue.add(new pizza("medium",cheese,beef,chicken ));
                    break;
                case 3:
                    System.out.println("Please enter the number of Beef toppings :");
                    beef = input.nextInt();
                    System.out.println("Please enter the number of Chicken toppings :");
                    chicken = input.nextInt();
                    System.out.println("Please enter the number of Cheese toppings :");
                    cheese = input.nextInt();
                    queue.add(new pizza("large",cheese,beef,chicken ));
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
        while (queue.peek()!=null)
        {
            pizza obj = queue.poll();
            totol_amount+=obj.calcCost();
            System.out.println(obj.getDescription());
        }
        System.out.println("***************************************************************************");

        System.out.println("The Price is: "+totol_amount+" The Tax 2% : "+(2.0/totol_amount));
        System.out.println("The Total amount is "+(totol_amount+(2.0/totol_amount)));
        System.out.println("***************************************************************************");

    }
}