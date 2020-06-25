import java.util.ArrayList;
import java.util.List;

public class thread_task
{
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<Thread>();
        for (long i=0; i<1000000000; i++)
        {
          if((i+1)%250000==0)
          {
              sum_class obj = new sum_class((i-250000+1),i+1);
              list.add(obj);
              obj.start();

          }
        }
        for (Thread t:list)
        {
            t.join();
        }
      sum_class.display();
        long sum = 0;
        for(long i=1; i<=1000000000; i++)
        {
            sum+=i;

        }
        System.out.println("and the other sum is "+sum);
    }


}
class sum_class extends Thread
{
    static long sum = 0;
    long start,end;
    sum_class(long start,long end)
    {
        this.start = start;
        this.end = end;
    }
    public void run()
    {
        for (long i=start; i<=end; i++)
        {
            sum+=i;
        }
        System.out.println("the sum is "+sum+" start  = "+start+" the end is "+end);
    }
     static  void display()
    {
        System.out.println("the total sum is "+sum);

    }
}