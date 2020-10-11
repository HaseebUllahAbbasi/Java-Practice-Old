package array_task;

import java.util.*;
public class reverse_array
{

	static Scanner input;
	public static void main(String[] args) 
	{
		int array[] = takeinput();
		System.out.println(Arrays.toString(array));
		reverse_array(array);
		System.out.println(Arrays.toString(array));
		
	}
	public static int[] takeinput()
	{

		input = new Scanner(System.in);
		int size = input.nextInt();
		int array[] = new int [size];
		for (int i=0; i<size; i++)
		{
			array[i] = input.nextInt();
		}
		return array;
	}
	public static int[] reverse_array(int[] array)
	{
		int size = array.length-1;
		for(int i=0; i<(size+1)/2; i++)
		{
			int temp = array[i];
			array[i] = array[size-i];
			array[size-i] = temp;  
		}
		return array;
	}
}