public class series
{
	public static void main(String[] args) 
	{
		int ext = 0;
		int num = 1;
		for (int i=0; i<5; i++) 
		{
			num= 1+ext;
			for (int j=i; j<5; j++ ) 
			{
				System.out.print(num+" ");
				num+=2;
			}
			System.out.println(" ");
			ext+=2;			
		}
		
	}
}