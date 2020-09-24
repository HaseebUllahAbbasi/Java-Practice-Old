package com.sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int array [] ={2,44,12,15,3,1,45};
        for(int i=1; i< array.length; i++)
        {
            int a=0;
            while (i>0 && array[i]<array[i-1])
            {
                int temp = array[i];
                array[i]=array[i-1];
                array[i-1]= temp;
                i--;
            }
        }
            System.out.println(Arrays.toString(array));
    }
}
