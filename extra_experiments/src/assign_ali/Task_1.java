package assign_ali;

import java.util.ArrayList;
import java.util.Scanner;

public class Task_1
{
    static int no = 1;

    public static void main(String[] args)
    {
        Scanner intput_int = new Scanner(System.in);
        Scanner intput_string = new Scanner(System.in);
        ArrayList<Item> list = new ArrayList<>();
        int price;
        String name;
        while(true)
        {

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
        System.out.println("4 : Exit");
        System.out.println("================================");
    }
}

class Item
{
    public Item(int number, String name, int price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    int number;
    String name;
    int price;

    @Override
    public String toString() {
        return
                "number =" + number +
                ", name ='" + name + '\'' +
                ", price =" + price ;
    }
}
