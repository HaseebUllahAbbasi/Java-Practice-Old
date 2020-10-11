package piza_assignemnt;
import java.util.ArrayList;
import java.util.Scanner;
class Pizza_Shop
{
    private String pizza_size;
    private int cheesetopping;
    private int beeftopping;
    private int chickentopping;
    Pizza_Shop(String pizza_size,int cheesetopping,int beeftopping,int chickentopping)
    {
        this.pizza_size = pizza_size;
        this.cheesetopping = cheesetopping;
        this.beeftopping = beeftopping;
        this.chickentopping = chickentopping;
    }
    public String getSize() {
        return pizza_size;
    }
    public void setSize(String pizza_size) {
        this.pizza_size = pizza_size;
    }
    public int getCheese_topping() {
        return cheesetopping;
    }
    public void setCheese_topping(int cheesetopping) {
        this.cheesetopping = cheesetopping;
    }
    public int getBeeftopping() {
        return beeftopping;
    }
    public void setBeef_toppings(int beeftopping) {
        this.beeftopping = beeftopping;
    }
    public int getChicken_topping() {
        return chickentopping;
    }
    public void setChickentopping(int chickentopping) {
        this.chickentopping = chickentopping;
    }
    public String getDescription()
    {
        return "You have ordered: 1 "+pizza_size+" Pizza with"+chickentopping+" chicken_toppings , "+beeftopping+", beef_toppings: "+chickentopping+" cheese_toppings : "
                +" and Pizza Cost "+calculateCost();
    }
    public int calculateCost()
    {
        int bill = 0;
        if(pizza_size.equals("small")){
                bill+=10;
                int  totaltopping= beeftopping+cheesetopping+chickentopping;
                bill = bill + totaltopping *2;
        }
        else if(pizza_size.equals("medium")){
            bill+=12;
            int  totaltopping = beeftopping+cheesetopping+chickentopping;
            bill = bill + totaltopping *2;
        }
        else if(pizza_size.equals("large")){
            bill+=14;
            int  totaltopping = beeftopping+cheesetopping+chickentopping;
            bill = bill + totaltopping *2;
        }
        return bill;
    }
}
public class Main_2
{
    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);
        ArrayList<Pizza_Shop> list = new ArrayList<>();
        int choice= 1;
        while (choice!=4){
            System.out.println("1. for small, 2. for medium, 3. for large 4. Exit");
            System.out.println("Enter your choice: ");
            int beef;
            int chicken;
            int cheese;
            choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println(" Please enter the number of Beef toppings :");
                     beef = input.nextInt();
                    System.out.println("  Please enter the number of Chicken toppings :");
                     chicken = input.nextInt();
                    System.out.println("Please enter the number of Cheese toppings :");
                     cheese = input.nextInt();
                    list.add(new Pizza_Shop("small",cheese,beef,chicken ));
                    break;
                case 2:
                    System.out.println(" enter the number of Beef toppings :");
                     beef = input.nextInt();
                    System.out.println(" enter the number of Chicken toppings :");
                     chicken = input.nextInt();
                    System.out.println(" enter the number of Cheese toppings :");
                     cheese = input.nextInt();
                    list.add(new Pizza_Shop("medium",cheese,beef,chicken ));
                    break;
                case 3:
                    System.out.println(" enter the number of Beef toppings :");
                    beef = input.nextInt();
                    System.out.println(" enter the number of Chicken toppings :");
                    chicken = input.nextInt();
                    System.out.println("enter the number of Cheese toppings :");
                    cheese = input.nextInt();
                    list.add(new Pizza_Shop("large",cheese,beef,chicken ));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please enter the given key");
                    break;
            }
        }
        System.out.println("Order details:");
        System.out.println("…………………………………………………………………………………………..");
        int totol_bill= 0;
        for (Pizza_Shop obj:list)
        {
            totol_bill+=obj.calculateCost();
            System.out.println(obj.getDescription());
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("The Price is: "+totol_bill+" The Tax 2% : "+(2.0/totol_bill));
        System.out.println("The Total amount is "+(totol_bill+(2.0/totol_bill)));
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}
