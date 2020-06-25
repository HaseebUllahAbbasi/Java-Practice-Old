/*
Fees Calculation Program
*/
public class Main_3
{
    public static void main(String[] args)
    {
        double for_four_year = 0;
        double tutuion_fee = 15000;
        for(int i=0; i<7; i++)
        {
            double perctange  = tutuion_fee*0.1;
            tutuion_fee = tutuion_fee+perctange;
            if(i<4)
            {

                for_four_year+=tutuion_fee;
              //  System.out.println(for_four_year);
            }
        }
        System.out.println("The tution fee after seven years "+tutuion_fee);
        System.out.println("The total tution fee of first four year "+for_four_year);

    }
}
