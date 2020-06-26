public class Transport
{
    int petrol;
    int distance_covered;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    int price;

    Transport(int petrol,int distance_covered,int price)
    {
        this.petrol = petrol;
        this.distance_covered = distance_covered;
        this.price = price;
    }

    public void setPetrol(int petrol)
    {
        this.petrol = petrol;
    }

    public void setDistance_covered(int distance_covered)
    {
        this.distance_covered = distance_covered;
    }



    public int getPetrol()
    {
        return petrol;
    }

    public int getDistance_covered()
    {
        return distance_covered;
    }
    public void fill_petrol(int petrol)
    {
        if(this.petrol+petrol>30)
        {
            System.out.println("It is going to much over");
        }
        else
        {
            this.petrol = this.petrol+petrol;
            System.out.println("Petrol is filled "+petrol);
        }
    }
    public void travel(int distance_covered) throws InSufficient_Petrol
    {
        if((petrol-distance_covered)>0)
        {
            this.distance_covered +=distance_covered;
            petrol = petrol-distance_covered;
            System.out.println(this.distance_covered+"KM distance is covered");
        }
        else
        {
            throw new InSufficient_Petrol();

        }

    }

    @Override
    public String toString() {
        return "Transport{" +
                "petrol=" + petrol +
                ", distance_covered=" + distance_covered +
                ", price=" + price +
                '}';
    }
}


