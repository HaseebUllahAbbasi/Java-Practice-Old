class stk
{
	int redo_top;
	int redo_size;
	int top;
	int size; 
	String array[];
	String redo[];
	stk()
	{
		redo_size = 10;
		redo_top = 0;
		array  = new String[10]; 
		top = 0;
		redo  = new String[10];
		size = 10;
	}
	public void push(String arg)
	{
		if(top<size)
		{
			array[top++] = arg;	
			redo_size = 10;
			redo_top = 0;
			redo  = new String[10];
		}
		else
			System.out.println("full");
	}
	public void undo()
	{
		if(top>0)
		{
			redo[redo_top++] = array[top-1]; 
			//System.out.println("taken "+redo[redo_top-1]);
			top--;	
		}
		else
			System.out.println("already null");
	}
	public void states()
	{
		if(redo_top>0&&top>0)
		{
			System.out.println(""+redo[redo_top-1] +" "+  array[top-1]);		
		}
		else if(redo_top==0&&top>0)
		{
			System.out.println(""+redo[redo_top] +" "+  array[top-1]);		
		}
		else if(top==0&&redo_top>0)
		{
			System.out.println(""+redo[redo_top-1] +" "+  array[top]);	
		}

	}
}
public class undo_redo
{
	public static void main(String[] args) 
	{
		stk obj = new stk();
		obj.push("ok");
		obj.push("fine");
		obj.push("hearted");
		//obj.states();
		obj.undo();
		//obj.states();
		obj.push("hearted");
		//obj.states();
		obj.undo();
		obj.undo();
		obj.undo();
		obj.states();
		
		
			
	}
}