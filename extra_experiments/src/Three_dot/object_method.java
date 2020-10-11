package Three_dot;
public class object_method
{
	public static void call_me(Object ...object)
	{
		for(Object obj:object) 
		{
			System.out.print(obj+" ");	
		}

	}
	public static void main(String[] args) 
	{
		object_method.call_me(1,2,3,"ok");		
	}

}