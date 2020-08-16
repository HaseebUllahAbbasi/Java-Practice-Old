package thirty_days;


import java.util.Scanner;

public class Solution
{
    public static void method (int number)
    {
        String number_bin = "";
        while(number>0)
        {
          //  System.out.println(number);
            number_bin += Integer.toString(number%2);
            number/=2;
        }
        //System.out.println(number_bin);
        StringBuilder str = new StringBuilder(number_bin);
        str =str.reverse();
        System.out.println(str);
        cons_occur(str.toString());
    }
    static void cons_occur(String str)
    {
        int max = 0;
        int count = 0 ;
        boolean prev = false;
        for (int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)=='1')
            {
                //System.out.println("inc");
                count++;
            }
            else if(str.charAt(i)=='0')
            {
                count=0;
            }
            if(count>max)
            {
                System.out.println(max);
                max = count;
            }
        }
        System.out.println(max);
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        method(n);
    }
}

/*
Objective
Today, we're working with binary numbers. Check out the Tutorial tab for learning materials and an instructional video!

Task
Given a base- integer, , convert it to binary (base-). Then find and print the base- integer denoting the maximum number of consecutive 's in 's binary representation.

Input Format

A single integer, .

Constraints

Output Format

Print a single base- integer denoting the maximum number of consecutive 's in the binary representation of .

Sample Input 1

5
Sample Output 1

1
Sample Input 2

13
Sample Output 2

2
Explanation

Sample Case 1:
The binary representation of  is , so the maximum number of consecutive 's is .

Sample Case 2:
The binary representation of  is , so the maximum number of consecutive 's is .
 */