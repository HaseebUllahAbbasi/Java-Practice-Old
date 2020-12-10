package assign_ali;

import java.util.LinkedList;
import java.util.Scanner;

public class Task_3
{
    static  int no =1;
    public static void main(String[] args)
    {
        Scanner intput_int = new Scanner(System.in);
        Scanner intput_string = new Scanner(System.in);
        LinkedList<Item> list = new LinkedList<>();
        while(true)
        {
            int price;
            String name;
            print_list();
            int choice = intput_int.nextInt();
            switch (choice)
            {

                case 1:
                    System.out.println("write price");
                     price = intput_int.nextInt();
                    System.out.println("write name");
                     name = intput_string.nextLine();
                    list.add(new Item(no++,name,price));
                    break;
                case 2:
                    for (Item item: list ) {
                        System.out.println(item);
                    }
                    break;
                case 3:
                    System.out.println("remove at the index");
                    int remove_index = intput_int.nextInt();
                    list.remove(remove_index);
                    break;
                case 4:
                    System.out.println("write price");
                     price = intput_int.nextInt();
                    System.out.println("write name");
                     name = intput_string.nextLine();
                    break;

                case 5:
                default:
                    return;
            }
        }
    }
    static void print_list()
    {
        System.out.println("================================");
        System.out.println("1 : Insert Element");
        System.out.println("2 : Display Item");
        System.out.println("3 : Delete Item");
        System.out.println("4 : Search Item");
        System.out.println("5 : Exit");

        System.out.println("================================");
    }
}

