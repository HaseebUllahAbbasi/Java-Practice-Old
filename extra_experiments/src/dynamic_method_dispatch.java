public class dynamic_method_dispatch
{
	public static void main(String args[])
	{
		check obj = new ok();
		obj.nahi();
	}	
}
 class check
{
	public void nahi()
	{
		System.out.println("this is nahi of check");	
	}
	public void acha()
	{
		System.out.println("this is check");
	}

}
 class ok extends check
{
	public void nahi()
	{
		System.out.println("nahi mathod of ok");
	}
	public void yes()
	{
		System.out.println("yes mathod of ok");
	}

}