import java.util.Scanner;

public class hour_glass
{
    public static int calculate(int array[][])
    {
        int sum= 0;
        int max = -100;
        for (int i=0; i<array.length; i++)
        {

            for (int j=0; j<array[i].length; j++)
            {
                //System.out.print(array[i][j]+" ");

                if(i>0&&j>0&&j<5&&i<5)
                {
                    sum = array[i-1][j-1]+array[i-1][j]+array[i-1][j+1]+array[i][j]+array[i+1][j-1]+array[i+1][j]+array[i+1][j+1];
                    if(max<sum)
                    {
                        max = sum;
                    }
                }


            }
            //System.out.println();
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int array[][] = new int[6][6];
        for (int i=0; i<array.length; i++)
        {
            for (int j=0; j<array[i].length; j++)
            {
                array[i][j] = input.nextInt();
            }
        }
     System.out.println(calculate(array));

    }
}
