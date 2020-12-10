package hackerRank.subArray;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int array[] = new int[size];
        for(int i=0; i<size; i++)
            array[i] = input.nextInt();
        System.out.println(sub_array(array));
    }
    public static int sub_array(int[] array)
    {
        int count = 0;
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array.length; j++)
            {
                int sum = 0;
                for(int k=i; k<=j; k++)
                {
                    sum+=array[k];
                    int  a =  array.length;
                }
                if(sum<0)
                    count++;
                //System.out.println();
            }
        }
        return  count;
    }
}