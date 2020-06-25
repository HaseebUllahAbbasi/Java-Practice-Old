
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter number of cashiers");
        int no_of_cashier = input.nextInt();
        System.out.println("Please enter time in milliseconds for simulation");
        Long time = input.nextLong();
        Cashier array[] = new Cashier[no_of_cashier];
        for (int i=0; i<no_of_cashier; i++)
        {
            array[i] = new Cashier();
        }
        array[0].setTotal_time(time);
        int  loop = 1;
        int select ;
        while (loop==1)
        {
            print_options();
            select = input.nextInt();
            switch(select)
            {
                case 1:
                    int number_generated = rand.nextInt(no_of_cashier);
                    array[number_generated].add_customer();
                    System.out.println("Customer added in que "+(number_generated+1));
                    array[number_generated].currently_customer_in_queue();
                    break;
                case 2:
                    number_generated = rand.nextInt(no_of_cashier);
                    array[number_generated].serve_customer();
                    if(array[number_generated].getTotal_time()>array[number_generated].getTime_consumed()&&array[number_generated].no_of_customer()>0)
                    {
                        System.out.println("Customer removed in que "+(number_generated+1));
                    }
                    break;
                case 3:
                    loop++;
                    break;
                case 4:
                    for (int i=0; i<no_of_cashier; i++)
                    {
                        array[i].print_que();
                    }
                    break;

                default:
                    System.out.println("Please select from the given options");
                    break;
            }
        }
        System.out.println("Total Customer Proceeded are : "+array[0].getTotal_customer_proceeded());
        System.out.println("Maximum waiting time of a customer  : "+array[0].getMax_wait_time());
        System.out.println("Maximum Queue Length  : "+array[0].getMax_que_length());
        int remaining_customers = 0;
        for (int i=0; i<no_of_cashier; i++)
        {
            remaining_customers+=array[i].no_of_customer();
        }
        System.out.println("Remaining Customers  are : "+remaining_customers);



    }
    public static void print_options()
    {
        System.out.println("\n");
        System.out.println("Please select any of the option ");
        System.out.println("1 to add customer");
        System.out.println("2 to serve customer");
        System.out.println("3 to close");
        System.out.println("4 display all lists");
    }

}