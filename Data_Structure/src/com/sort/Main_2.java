package com.sort;

import com.sort.Selection.Selection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main_2
{
    public static void main(String[] args)
    {
        int array[] = {89,22,1,9,67,35,98};

        Selection.sort(array);

        System.out.println(Arrays.toString(array));

    }
}
