import java.util.Scanner;

public class Rotation
{
    public static int[] roatate(int array[],int times)
    {
        int temp[] = new int[array.length];
        for (int j=0; j<times; j++)
        {
            for (int i=0; i<array.length; i++)
            {
                temp [i] = array[(i+1)%(array.length)];
            }
            for (int n=0; n<array.length; n++)
            {
                array[n] = temp[n];
            }

            }
        return array;
    }
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        int size =  input.nextInt();
        int roattion = input.nextInt();
        int array[] = new int[size];
        for (int i=0; i<size; i++)
        {
            array[i] = input.nextInt();
        }
         int new_array[] =roatate(array,roattion);
        for (int i=0; i<size; i++)
        {
            System.out.print(new_array[i]+" ");
        }
    }
}
