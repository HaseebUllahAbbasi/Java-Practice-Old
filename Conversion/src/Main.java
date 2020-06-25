/*
Calculate three currencies
respectively 
*/
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int loop = 1;
        int Doller[] = {20,10,5};
        int Euro[] = {5,10,50};
        int Sar[] = {200,500,10};
        while(loop==1)
        {
            Main.print_info();
            int select = input.nextInt();
            switch(select)
            {
                case 1:
                    Main.Dollers(Euro,Sar,Doller);
                    break;
                case 2:
                    Main.Euros(Euro,Sar,Doller);
                    break;
                case 3:
                    Main.SAR(Euro,Sar,Doller);
                    break;
                case 0:
                    loop+=1;
                    break;
            }
        }
    }
    public static void print_info()
    {
        System.out.println("Please select the option from the given list");
        System.out.println("1 to print the total amount in Dollers ");
        System.out.println("2 to print the total amount in Euros ");
        System.out.println("3 to print the total amount in SAR ");
        System.out.println("0 to Exit Program ");

    }
    public static void Dollers(int Euro[],int Sar[],int Doller[])
    {
        double total_sum = 0;
        double calculation;
        for (int doller: Doller)
        {
            total_sum = total_sum+doller;
        }
        int total_euro = 0;
        for (int euro: Euro)
        {
            total_euro = total_euro+euro;
        }
        calculation = (1.0/0.92)*total_euro;
        total_sum = total_sum+calculation;

        int total_sar = 0;
        for (int sar: Sar)
        {
            total_sar = total_sar+sar;
        }
        calculation = (1.0/3.76)*total_sar;
        total_sum = total_sum+calculation;
        System.out.println("the Total dollers are : "+total_sum);
    }
    public static void Euros(int Euro[],int Sar[],int Doller[])
    {
        double total_sum = 0;
        double calculation;
        for (int euro: Euro)
        {
            total_sum = total_sum+euro;
        }
        int total_doller = 0;
        for (int doller: Doller)
        {
            total_doller = total_doller+doller;
        }
        calculation = (1.0/1.09)*total_doller;
        total_sum = total_sum+calculation;

        int total_sar = 0;
        for (int sar: Sar)
        {
            total_sar = total_sar+sar;
        }
        calculation = (1.0/4.09)*total_sar;
        total_sum = total_sum+calculation;
        System.out.println("the Total Euros are : "+total_sum);
    }

    public static void SAR(int Euro[],int Sar[],int Doller[])
    {
        double total_sum = 0;
        double calculation;
        for (int sar: Sar)
        {
            total_sum = total_sum+sar;
        }
        int total_doller = 0;
        for (int doller: Doller)
        {
            total_doller = total_doller+doller;
        }
        calculation = (1.0/0.27)*total_doller;
        total_sum = total_sum+calculation;

        int total_euro = 0;
        for (int euro: Euro)
        {
            total_euro = total_euro+euro;
        }
        calculation = (1.0/0.24)*total_euro;
        total_sum = total_sum+calculation;
        System.out.println("the Total SAR are : "+total_sum);
    }
}
