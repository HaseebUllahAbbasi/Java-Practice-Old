import javax.swing.plaf.synth.SynthTextAreaUI;

public class city_Main
{
    public static void main(String[] args)
    {
        city boston = new city("Boston","U.S.A","42 North","71 West",4590000);
        city sydny = new city("Sysny","Australia","33 South","151 East",4627345);
        city johannesburg = new city("Johannesburg","South Africa","26 South","28 East",1009035);
        city kuala_Lampur = new city("Kuala Lampur","Malaysia","3 North","101 East",1627172);
        city rio = new city("Rio de Jenerio","Brazil","22 South","43 East",6323037);

        System.out.println("toString methods");
        System.out.println(boston);
        System.out.println(rio);
        System.out.println(sydny);

        System.out.println("information of johannesburg");
        System.out.println(johannesburg.getName()+" "+johannesburg.getCountry()+" "+johannesburg.getLatitude()+" "+johannesburg.getLongitude()+" "+johannesburg.getPopulaion());

        System.out.println("mutataion of population");
        System.out.println("Before :the popullation of the city"+kuala_Lampur.getName()+" is "+kuala_Lampur.getPopulaion());
        kuala_Lampur.setPopulaion(2342424);
        System.out.println("After :the popullation of the city"+kuala_Lampur.getName()+" is "+kuala_Lampur.getPopulaion());

    }
}
