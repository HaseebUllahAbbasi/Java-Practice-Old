package assign_ali;

import java.util.Arrays;
import java.util.Scanner;

public class Task_2
{
    public static void sort(int array[])
    {
        for(int i=0; i< array.length-1; i++)
        {
            for (int j=0; j< array.length-1-i; j++)
            {
                if(array[j]>array[j+1])
                {
                    int temp  = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    static boolean search(int array[],int value, int left, int right)
    {
        if(left>right)
            return false;
        int mid = (left+right)/2;
        if(array[mid]==value)
        {
            return true;
        }
        else if(value< array[mid])
            return search(array,value,left,mid-1);
        else
            return search(array,value,mid+1,right);
    }

    public static void main(String[] args) {

        System.out.println("enter the no of elements ");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int array [] = new int[size];
        System.out.println("enter the items ");
        for (int i=0; i<size; i++)
        {

            System.out.println("enter the item "+(i+1));
            array[i] = input.nextInt();
        }
        sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("enter the number to serch ");
        int num = input.nextInt();
        if( search(array,num,0,size))
        {
            System.out.println("found");
        }
        else
        {
            System.out.println("item not in the list");
        }


    }
}
