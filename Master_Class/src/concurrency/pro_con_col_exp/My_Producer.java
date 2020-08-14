package concurrency.pro_con_col_exp;

import java.util.List;
import java.util.Random;

public class My_Producer implements Runnable
{
    List<String> buffer;
    String color;
    My_Producer(List<String> buffer,String color)
    {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run()
    {
        Random random = new Random();
        String nums[] = {"1","2","3","4","5"};
        for (String num : nums)
        {
            try
            {
            System.out.println(color+" Adding ..."+num);
            synchronized (buffer)
            {
                buffer.add(num);
            }
            Thread.sleep(random.nextInt(400));
            } catch (InterruptedException interruptedException)
            {
                interruptedException.printStackTrace();
            }
            System.out.println(color+" Adding EOF and exiting");
            synchronized (buffer)
            {
                buffer.add("EOF");
            }

        }
    }
}
