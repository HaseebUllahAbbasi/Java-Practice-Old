
public class Customer
{
    private int number;
    private int time_elapse;
    private int service_time;
    private int waiting_time;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTime_elapse() {
        return time_elapse;
    }

    public void setTime_elapse(int time_elapse) {
        this.time_elapse = time_elapse;
    }

    public int getService_time() {
        return service_time;
    }

    public void setService_time(int service_time) {
        this.service_time = service_time;
    }

    public int getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }

    Customer(int number, int time_elapse, int service_time, int waiting_time)
    {
        this.number = number;
        this.time_elapse = time_elapse;
        this.service_time = service_time;
        this.waiting_time = waiting_time;
    }
    @Override
    public String toString() {
        return "Customer{" +
                " number=" + number +
                ", time_elapse=" + time_elapse +
                ", service_time=" + service_time +
                ", waiting_time=" + waiting_time +
                '}';
    }
}
