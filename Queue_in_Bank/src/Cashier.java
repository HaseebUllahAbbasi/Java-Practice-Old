public class Cashier
{
    static int total_customer_proceeded = 0;
    static long max_wait_time = 0;
    static int max_que_length = 0;

    static long total_time;
    static long time_consumed = 0;
    Que que;

    public static long getTotal_time() {
        return total_time;
    }

    public static long getTime_consumed() {
        return time_consumed;
    }

    static int casheir_in_number=1;
    Cashier()
    {
        que = new Que(casheir_in_number++);
    }
    public void add_customer()
    {
        if(total_time>time_consumed)
        {
            que.add_customer();
            if(que.no_of_customer_in_Que()>max_que_length)
            {
                max_que_length = que.no_of_customer_in_Que();
            }
        }
        else
            System.out.println("Time Exceeded, service is closed");
    }
    public void serve_customer()
    {
        if(total_time>time_consumed && que.no_of_customer_in_Que()>0)
        {
            total_customer_proceeded++;
            long service_wait_time[] = que.serve_customer();
            time_consumed+=service_wait_time[0];
            if(service_wait_time[1]>max_wait_time)
            {
                max_wait_time = service_wait_time[1];
            }
        }
        else if(total_time>=time_consumed && que.no_of_customer_in_Que()>0)
            System.out.println("Time Exceeded, service is closed");
        else if(que.no_of_customer_in_Que()<0 && total_time<=time_consumed)
            System.out.println("There are no customer in this Que ");

    }
    public int no_of_customer()
    {
        return que.no_of_customer_in_Que();
    }
    public int currently_customer_in_queue()
    {
        System.out.println("there are "+que.no_of_customer_in_Que()+" in Que ");
        return que.no_of_customer_in_Que();
    }
    public void setTotal_time(long total_time) {
        this.total_time = total_time;
    }
    public void print_que()
    {
        que.print_list();
    }
    public long getMax_wait_time()
    {
        return max_wait_time;
    }
    public int getTotal_customer_proceeded()
    {
        return total_customer_proceeded;
    }
    public int getMax_que_length()
    {
        return max_que_length;
    }

}
