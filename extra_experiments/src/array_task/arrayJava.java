package array_task;
import java.io.*;
import java.util.*;

public class arrayJava 
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Scanner line = new Scanner(System.in);

        
        int number  = input.nextInt();
        //input.close();
        
        //input = new Scanner(System.in);
        String arr[] = new String[number];
        for(int i=0; i<number; i++)
        {
        	//System.out.println("inputing "+i);
            arr[i] = line.nextLine();
        }
        for(int i=0; i<number; i++)
        {
         	System.out.println(arr[i]);   
        	arrayJava.display(arr[i]);
        	System.out.println("");   
        	
        }

        

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
    public static void display(String ok)
    {
    	for(int i=0; i<ok.length(); i++)
    	{
    		if(i%2==0)
    		{
    			System.out.print(ok.charAt(i));
    		}
    	}
    	System.out.print(" ");
    	for(int i=0; i<ok.length(); i++)
    	{
    		if(i%2==1)
    		{
    			System.out.print(ok.charAt(i));
    		}
    	}

    }
}

