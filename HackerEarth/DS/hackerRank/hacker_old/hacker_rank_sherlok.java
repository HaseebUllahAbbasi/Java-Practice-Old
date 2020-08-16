import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.regex.*;

public class hacker_rank_sherlok
{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("size of array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("numbers of array");
        for (int i = 0; i < n; i++)
        {
            arr[i] = scanner.nextInt();
        }
        System.out.println("p and q");
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        sherlockAndMinimax(arr,p,q);

    }
    static int sherlockAndMinimax(int[] arr, int p, int q)
    {
        //System.out.println("funtion started");
        int M[] = new int[(Math.abs(p-q)+1)];
        int array[] = new int[Math.abs(p-q)+1];
        //System.out.println("math abs is"+(Math.abs(p-q)+1));
        int j=0;
        for(int i=p; i<=q; i++)
        {
            M[j] = i;
             array[j] = find_min(arr,i);
             j++;
        }
        int min_return = array[0];
        for (int a:array)
        {
            if(a<min_return)
                min_return = a;
            System.out.print(a);

        }
        System.out.println("function done");

        System.out.println(M[min_return]);

        return 0;
    }
    public static int find_min(int array[],int i)
    {
        //System.out.println("in  min function");
        int min = Math.abs(array[0]-i);
        for (int num: array)
        {
           // System.out.println(num-i);
            if(min>Math.abs(num-i))
            {
                min = Math.abs(num-i);
            }

        }
        //System.out.println("end  min function");

        return min;

    }
}
