package com.stats.formula;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList list = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.println("enter the size ");
        int size = input.nextInt();
        Double array [] = new Double[size];
        System.out.println("Please enter the data, write any else character if want to end");
        for (int i=0; i<size; i++)
        {
            array[i] = input.nextDouble();
        }
        Arrays.sort(array);
        mean(array);
        median(array);
    }
    public static void mean(Double array[])
    {
        Double sum = 0.0;
        for(double number:array)
        {
            sum+=number;
        }
        System.out.println("the avg is "+(sum/array.length));

    }
    public static void median(Double array[])
    {
        //System.out.println(Arrays.toString(array));
        int size = array.length;
        if(array.length%2==1)
        {
            //System.out.println((size+1)/2);
            System.out.println("Median is : "+array[(size-1)/2]);
        }
        else
        {
            System.out.println("Median is "+((array[size-1/2])+(array[(size-1/2)+1]))/2.0);
        }
    }
}
