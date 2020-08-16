import java.util.Scanner;
public class chess_task
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("please enter no of tests");
			
		int n = input.nextInt();
		int array[][][] = new int[n][][];

		for(int i=0; i<n; i++)
		{
			System.out.println("please enter no of diag");
			int p = input.nextInt(); 
			array[i] = new int[p][p];
			for(int j=0; j<p; j++)
			{
				for(int z=0; z<p; z++)
				{
					//for(int o =0; o<p; o++)
					//{
						array[i][j][z]= input.nextInt();
					//}
				}

			}
			//System.out.println("done with one test");
		}
		for(int i=0; i<n; i++)
		{

			int temp[][] = array[i];
			int sum_r =0;
			int sum_c =0;
			int number_r =0; 
			for(int j=0; j<temp[0].length; j++)
			{
				for(int z=0; z<temp[0].length; z++)
				{
					if(number_r==j)
						sum_r+=temp[j][z];
					//for(int o =0; o<p; o++)
					//{
					//System.out.print(array[i][j][z]+" ");
					System.out.print(temp[j][z]+" ");
					//}
				}
				System.out.println("");		
			}
			//System.out.println("done with one test");
		}
	}
}
/*
import java.util.Scanner;
public class chess_task
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		for(int i=0; i<n; i++)
		{
			//int p = input.nextInt();
			for(int j=0; j<n; j++)
			{
				if(i+j+1==n)
					System.out.print("*");
				else if(i==j)
				System.out.print("*");
				else
					System.out.print(" ");

			}
			System.out.println("");

		}
		
	}
}
*/