package concurrency.pro_con_col_exp;

import java.util.List;

public class My_Consumer implements Runnable
{
    List<String> buffer;
    String color;
    My_Consumer(List<String> buffer,String color)
    {
        this.color = color;
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
        while (true)
        {
            synchronized (buffer)
            {
                if(buffer.isEmpty())
                {
                    continue;
                }
                if(buffer.get(0).equals("EOF"))
                {
                    System.out.println("Exiting the prog");
                    break;
                }
                else
                {
                    System.out.println(color +" is removed"+buffer.remove(0));
                }

            }

        }

    }
}
