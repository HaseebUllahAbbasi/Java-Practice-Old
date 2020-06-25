
public class booked_Main
{
    public static void main(String[] args)
    {
        Booked person_1 = new Booked("Ubaid","29-5-2019",2,2500.0);
        Booked person_2 = new Booked("Umair","14-6-2016",5,2900.0,true);
        System.out.println(person_1);
        System.out.println(person_1.incidentals(1230));
        System.out.println(person_1.incidentals(1230,100));
        person_1.use_gym();
        person_1.use_gym();
        System.out.println("the amount to be taken from the "+person_1.getName()+" is :"+(person_1.getTotal_cost_of_incidentals()+person_1.getNo_of_nights()*person_1.getDaily_rate_charged()));
        System.out.println("the amount to be taken from the "+person_2.getName()+" is :"+(person_2.getTotal_cost_of_incidentals()+person_2.getNo_of_nights()*person_2.getDaily_rate_charged()));

    }
}
