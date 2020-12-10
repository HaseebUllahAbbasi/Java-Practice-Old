package com.Binary_Search;

public class Recursive
{
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
}
