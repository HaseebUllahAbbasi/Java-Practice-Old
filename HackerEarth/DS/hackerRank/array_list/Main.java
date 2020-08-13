package hackerRank.array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        List[] list = new List[size];
        for (int i=0; i<size; i++)
        {
            int max_numbers = input.nextInt();
            list[i] = new List();
            for (int j=0; j<max_numbers; j++)
            {
                list[i].add(input.nextInt());
            }
        }
        int search = input.nextInt();
        for (int i=0; i<search; i++)
        {
        //    System.out.println("q "+i);
            int list_num = input.nextInt() -1 ;
            int index = input.nextInt() -1;
            list[list_num].get_item(index);
        }
    }
}
class List
{
    ArrayList<Integer> list;
    List()
    {
        list = new ArrayList<>();
    }
    void add(int number)
    {
        list.add(number);
    }
    void get_item(int index)
    {
        if(index<list.size())
            System.out.println(list.get(index));
        else
            System.out.println("ERROR!");
        //System.out.println(" "+index + " "+list.size());
    }

}
