/*
Linear search is used on a collections of items. It relies on the technique of traversing a list from start to end by exploring properties of all the elements that are found on the way.

For example, consider an array of integers of size . You should find and print the position of all the elements with value . Here, the linear search is based on the idea of matching each element from the beginning of the list to the end of the list with the integer , and then printing the position of the element if the condition is `True'.

Implementation:

The pseudo code for this example is as follows :

for(start to end of array)
{
    if (current_element equals to 5)
    {
        print (current_index);
    }
}
If you want to determine the positions of the occurrence of the number  in this array. To determine the positions, every element in the array from start to end, i.e., from index  to index  will be compared with number , to check which element matches the number .

Time Complexity:

The time complexity of the linear search is  because each element in an array is compared only once.

Contributed by: Anand Jaisingh
*/

/*
Problem
Last Occurrence SOLVED
You have been given an array of size N consisting of integers. In addition you have been given an element M you need to find and print the index of the last occurrence of this element M in the array if it exists in it, otherwise print -1. Consider this array to be 1 indexed.

Input Format:

The first line consists of 2 integers N and M denoting the size of the array and the element to be searched for in the array respectively . The next line contains N space separated integers denoting the elements of of the array.

Output Format

Print a single integer denoting the index of the last occurrence of integer M in the array if it exists, otherwise print -1.

Constraints


*/
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception
    {
        int occur = 0;
        boolean found = false;
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int number  = input.nextInt();
        int array[] = new int[size];
        for(int i=0; i<size; i++)
        {
            array[i] = input.nextInt();
            if(array[i]==number)
                {
                    occur = i+1;
                    found = true;
                }
        }
        if(found)
        System.out.print(occur);
        else
        System.out.print(-1);
    }
}
