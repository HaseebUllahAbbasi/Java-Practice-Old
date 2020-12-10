package bilal_friend;

import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        Scanner input_int = new Scanner(System.in);
        Scanner input_line = new Scanner(System.in);
        int shirt_length;
        int shoe_length;
        System.out.println("Please Enter the no of Shirts");
        shirt_length = input_int.nextInt();
        Shirt[] shirts = new Shirt[shirt_length];
        int id;
        String category, brand,heel, leather;
        String fabrics;
        String slaves;
        String collar_type;
        float size, cost, price;
        System.out.println("enter the data of the shirts ");
        for (int i=0; i<shirt_length; i++)
        {
            System.out.println("enter the data od the shirt "+(i+1)+"\n");

            System.out.println("enter the id");
            id = input_int.nextInt();
            System.out.println("enter the category");
            category = input_line.nextLine();
            System.out.println("enter the brand");
            brand = input_line.nextLine();
            System.out.println("enter the category");
            category = input_line.nextLine();
            System.out.println("enter the fabrics");
            fabrics = input_line.nextLine();
            System.out.println("enter the slaves");
            slaves = input_line.nextLine();
            System.out.println("enter the collar_type");
            collar_type = input_line.nextLine();
            System.out.println("enter the size");
            size = input_int.nextInt();
            System.out.println("enter the cost");
            cost = input_int.nextInt();
            System.out.println("enter the price");
            price = input_int.nextInt();
            if(price<cost)
            {
                price = 2000;
                cost = 1000;
            }
            shirts[i] = new Shirt(id,category,brand,size,cost,price,fabrics,slaves,collar_type);
        }

        System.out.println("Please Enter the no of Shoes");
        shoe_length = input_int.nextInt();
        Shoe[] shoes = new Shoe[shoe_length];

        System.out.println("enter the data of the Shoes ");
        for (int i=0; i<shirt_length; i++)
        {
            System.out.println("enter the data od the Shoe "+(i+1)+"\n");

            System.out.println("enter the id");
            id = input_int.nextInt();
            System.out.println("enter the category");
            category = input_line.nextLine();
            System.out.println("enter the brand");
            brand = input_line.nextLine();
            System.out.println("enter the category");
            category = input_line.nextLine();
            System.out.println("enter the heel");
            heel = input_line.nextLine();
            System.out.println("enter the leather");
            leather = input_line.nextLine();
            System.out.println("enter the size");
            size = input_int.nextInt();
            System.out.println("enter the cost");
            cost = input_int.nextInt();
            System.out.println("enter the price");
            price = input_int.nextInt();
            if(price<cost)
            {
                price = 2000;
                cost = 1000;
            }
            shoes[i] = new Shoe(id,category,brand,size,cost,price,heel,leather);
        }
        System.out.println("the shirts ");
        for (Shirt shirt : shirts)
        {
            shirt.show();
        }
        System.out.println("the shoes ");
        for (Shoe shoe : shoes)
        {
            shoe.show();
        }

    }
}
