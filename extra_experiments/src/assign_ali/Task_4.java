package assign_ali;

import java.util.Arrays;
import java.util.Scanner;

public class Task_4
{
    public static void main(String[] args)
    {
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

    }
    static void sort(int arr[])
    {
        int n = arr.length;

        for (int i = 1; i < n; ++i)
        {
            int key = arr[i];

            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
