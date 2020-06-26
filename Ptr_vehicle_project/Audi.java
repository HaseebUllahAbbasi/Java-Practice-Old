public class Audi extends Car
{
    String Model;
    boolean status_grarge;
    boolean status_friend;

    Audi(int year,String registration_number,int price,String Model)
    {
        super( year, registration_number, price);
        this.Model = Model;
        status_grarge = false;
        status_friend = false;
    }
    Audi(int year,String registration_number,int price,String Model,int distance_covered,int petrol)
    {
        super(year, registration_number, petrol,distance_covered,price);
        this.Model = Model;
        status_grarge = false;
        status_friend = false;
    }
    public void give_to_friend()
    {
        status_friend = true;
        status_grarge = false;
        System.out.println("The Vehicle is given to friend");
    }
    public void take_from_friend()
    {
        status_friend = false;
        status_grarge = false;
        System.out.println("The Vehicle is taken from  friend");
    }
    public void put_in_garage()
    {
        status_grarge = true;
        status_friend = false;
        System.out.println("the Vehicle is in garage now");
    }
    public void get_out_of_garage()
    {
        status_grarge = false;
        status_friend = false;
        System.out.println("the Vehicle taken out of garage now");
    }

    @Override
    public void fill_petrol(int petrol)
    {
        if(status_grarge==false&&status_friend==false)
        {
            super.fill_petrol(petrol);
        }
        else if(status_friend==true)
        {
            System.out.println("Please take back the veicle from friend");
        }
        else if(status_grarge==true)
        {
            System.out.println("Please take the vehicle out of garage");
        }
    }


    @Override
    public void travel(int distance_covered) throws InSufficient_Petrol
    {
        if(status_friend==false&&status_grarge==false)
        {
            super.travel(distance_covered);
        }
        else if(status_friend==true)
        {
            System.out.println("Please take back the veicle from friend");
        }
        else if(status_grarge==true)
        {
            System.out.println("Please take the vehicle out of garage");
        }
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }
}
