import java.util.Scanner;
public class hackerRank
{
	int validate(int array[][])
	{
		int sum_e = 0;
		int sum_d = 0;
		for (int i =0; i<array[0].length]; i++) 
		{
			for ( j=0; j<array[0].length; j++) 
			{
					if(i==j)
						sum_d+=array[i][j];
					if(i+j+1 == array[0].length)
						sum_e+=array[i][j];
			}
		}
		return Math.abs(sum_e-sum_d);
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int size = input.nextInt(); 
		int array[][] = new int[size][];
		for(int i=0; i<size; i++)
		{
			for (j=0; j<size; j++)
			{
				array[i][j] = input.nextInt();
			}
		}
	}
}