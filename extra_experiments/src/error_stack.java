public class error_stack
{
	public static void main(String[] args) 
	{
		        error_stack.recursivePrint(1);
	}
	public static void recursivePrint(int num) 
	{
        System.out.println("Number: " + num);
         
        if(num == 0)
            return;
        else
            recursivePrint(++num);
    }
}
