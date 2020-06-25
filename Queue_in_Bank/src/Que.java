import java.util.ArrayList;
public class Que
{
    static int customer_number = 0;
    int waiting_time_for_customer = 0;
    ArrayList<Customer> que;
    int cashier_number;
    Que(int cashier_number)
    {
        que = new ArrayList<>();
        this.cashier_number = cashier_number;
    }
    public void add_customer()
    {
        waiting_time_for_customer = que.size()*20;
        Customer obj = new Customer(customer_number++,10,20,waiting_time_for_customer);
        que.add(obj);
    }
    public long[] serve_customer()
    {
        if(que.size()>0)
        {
            Customer obj =  que.remove(0);
            long service_wait_time[] = {obj.getService_time(),obj.getWaiting_time()};
            return service_wait_time;
        }
        else
        {
            return new long[]{0, 0};
        }
    }
    public int  no_of_customer_in_Que()
    {
        return que.size();
    }
    public void print_list()
    {
        System.out.println("Cashier number is : "+cashier_number);
        for (Customer obj:que)
        {
            System.out.println(obj);
        }
        System.out.println();
    }
}