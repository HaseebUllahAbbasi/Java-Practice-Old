
public class Booked
{
    String name;
    String first_date_of_stay;
    int no_of_nights;
    double daily_rate_charged;
    boolean breakfast;
    long total_cost_of_incidentals;
    int gym = 0;
    Booked(String name,String first_date_of_stay,int no_of_nights,double daily_rate_charged)
    {
        this.name = name;
        this.first_date_of_stay = first_date_of_stay;
        this.no_of_nights = no_of_nights;
        this.daily_rate_charged = daily_rate_charged;
        this.breakfast = false;
        this.total_cost_of_incidentals = 0;
    }
    Booked(String name,String first_date_of_stay,int no_of_nights,double daily_rate_charged,boolean breakfast)
    {
        this.name = name;
        this.first_date_of_stay = first_date_of_stay;
        this.no_of_nights = no_of_nights;
        this.daily_rate_charged = daily_rate_charged;
        this.breakfast = breakfast;
        this.total_cost_of_incidentals = 0;
    }
    public boolean incidentals(long amount)
    {
        if(amount<=0)
        {
            System.out.println("Please enter the postive amount not the negative amount");
            return false;
        }
        else
        {
            total_cost_of_incidentals = total_cost_of_incidentals +amount;
            return true;
        }
    }
    public boolean incidentals(long amount_1,long amount_2)
    {
        if(amount_1<=0&&amount_2<=0)
        {
            System.out.println("Please enter the postive amount not the negative amount");
            return false;
        }
        else
        {
            total_cost_of_incidentals = total_cost_of_incidentals +amount_1+amount_2;
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_date_of_stay() {
        return first_date_of_stay;
    }

    public void setFirst_date_of_stay(String first_date_of_stay) {
        this.first_date_of_stay = first_date_of_stay;
    }

    public int getNo_of_nights() {
        return no_of_nights;
    }

    public void setNo_of_nights(int no_of_nights) {
        this.no_of_nights = no_of_nights;
    }

    public double getDaily_rate_charged() {
        return daily_rate_charged;
    }

    public void setDaily_rate_charged(double daily_rate_charged) {
        this.daily_rate_charged = daily_rate_charged;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public long getTotal_cost_of_incidentals() {
        return total_cost_of_incidentals;
    }

    public void setTotal_cost_of_incidentals(long total_cost_of_incidentals) {
        this.total_cost_of_incidentals = total_cost_of_incidentals;
    }

    public int getGym() {
        return gym;
    }

    @Override
    public String toString()
    {
        return "Booked{" +
                "name='" + name + '\'' +
                ", first_date_of_stay='" + first_date_of_stay + '\'' +
                ", no_of_nights=" + no_of_nights +
                ", daily_rate_charged=" + daily_rate_charged +
                ", breakfast=" + breakfast +
                ", total_cost_of_incidentals=" + total_cost_of_incidentals +
                ", gym=" + gym +
                '}';
    }

    public void setGym(int gym) {
        this.gym = gym;
    }

    public void use_gym()
    {
        if(gym==0)
        {
            gym++;
        }
        else
        {
            total_cost_of_incidentals = total_cost_of_incidentals+10;
        }
    }
}


