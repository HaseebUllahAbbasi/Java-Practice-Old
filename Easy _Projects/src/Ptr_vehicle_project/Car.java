public class Car extends Transport
{
    int Year;
    String registration_number;
    Car(int year,String registration_number,int price)
    {
        super(0,0,price);
        this.Year = Year;
        this.registration_number = registration_number;
    }
    Car(int Year,String registration_number,int petrol, int distance_covered,int price)
    {
        super(petrol,distance_covered,price);
        this.Year = Year;
        this.registration_number = registration_number;
    }

    public int getYear()
    {
        return Year;
    }

    public void setModel(int Year) {
        Year = Year;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Year=" + Year +
                ", registration_number='" + registration_number + '\'' +
                ", petrol=" + petrol +
                ", distance_covered=" + distance_covered +
                ", price=" + price +
                '}';
    }

    @Override
    public void fill_petrol(int petrol)
    {
        super.fill_petrol(petrol);

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
