public class Driver
{
    public static void main(String args[])
    {

        // all the objects
        Honda honda_obj = new Honda(2016,"skp-2020",20000,"CP200");
        Moto_GP_Bike Moto_obj = new Moto_GP_Bike(2016,"skp-2020",20000,"CP200");
        Cultus cultus_obj = new Cultus(2016,"skp-2020",20000,"CP200");
        Audi audi_obj = new Audi(2016,"skp-2020",20000,"CP200");
        try
        {
            audi_obj.fill_petrol(20);
            audi_obj.travel(2);
            audi_obj.give_to_friend();
            audi_obj.travel(5);
            audi_obj.take_from_friend();
            audi_obj.travel(10);

        }
        catch(Exception exception)
        {
            System.out.println("InSufficient Petrol, Please refill it");
        }



    }
}
