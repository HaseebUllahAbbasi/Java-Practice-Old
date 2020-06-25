/*
2D array with Borders 
*/


import java.util.Scanner;

public class ptr_task
{
    public static void main(String[] args) {
        System.out.print("Enter 2 Dimensional array size : ");
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int column=sc.nextInt();

        System.out.println("Enter array elements : ");

        int arrayD[][]=new int[row][column];


        for(int i=0; i<row;i++)
        {
            for(int j=0; j<column;j++)
            {
                arrayD[i][j]=sc.nextInt();
            }
        }
        sum_Avg(arrayD);
        largestInArray(arrayD);
        isPrime(arrayD);
        border(arrayD);
    }
    public static void sum_Avg(int arr[][])
    {
        int total = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                total += arr[row][column];
            }

        }
        System.out.println("Sum of 2D array is :"+" "+total);
        double Avg=total/arr.length;
        System.out.println("Average of 2D array is :"+" "+Avg);


    }
    public static void largestInArray(int arry[][])
    {
        int largest=arry[0][0],smallest=arry[0][0];

        for (int row = 0; row < arry.length; row++)
        {

            for (int col = 0; col < arry[row].length; col++)
            {
                if (largest < arry[row][col])
                {
                    largest = arry[row][col];
                }
            }


        }
        System.out.println("The largest element of array"
                + " = " + largest);

        for (int row = 0; row < arry.length; row++)
        {
            for (int col = 1; col < arry[row].length; col++)
            {
                if (smallest > arry[row][col])
                {
                    smallest = arry[row][col];
                }
            }


        }
        System.out.println("The smallest element of are  "+"="+ smallest);
    }
    public static void isPrime(int ar[][])
    {
        int n,f;
        for (int row = 0; row < ar.length; row++) {
            for (int column = 0; column < ar[row].length; column++) {
                n=ar[row][column];
                f=0;
                for(int k=2;k<n;k++)
                {
                    if(n%k==0)
                    {
                        f=1;
                        ar[row][column]=0;
                        System.out.println(ar[row][column]);
                    }

                }
                if(f==0)
                {
                    System.out.println(ar[row][column]);
                }
            }
        }
    }
    public static void border(int ary[][])
    {
        for(int i=0; i<ary.length;i++)
        {
            for(int j=0; j<ary[i].length-1;j++)
            {
                System.out.print(ary[i][j]);

            }
            System.out.println();

        }
    }
}
