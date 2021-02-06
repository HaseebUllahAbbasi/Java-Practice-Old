public class Bike extends Transport
{
    int Year;
    String registration_number;
    Bike(int year,String registration_number,int price)
    {
        super(0,0,price);
        this.Year = Year;
        this.registration_number = registration_number;
    }
    Bike(int Year,String registration_number,int petrol, int distance_covered,int price)
    {
        super(petrol,distance_covered,price);
        this.Year = Year;
        this.registration_number = registration_number;
    }
    @Override
    public void fill_petrol(int petrol)
    {
        super.fill_petrol(petrol);

    }


    public int getYear()
    {
        return Year;
    }

    public void setModel(int model) {
        Year = model;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number)
    {
        this.registration_number = registration_number;
    }

    @Override
    public void travel(int distance_covered) throws InSufficient_Petrol
    {
        super.travel(distance_covered);
    }
}
