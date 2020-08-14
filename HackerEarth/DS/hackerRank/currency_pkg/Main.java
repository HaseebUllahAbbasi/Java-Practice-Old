package hackerRank.currency_pkg;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Double currency = input.nextDouble();
        /*
        Locale pak = new Locale("Urdu","Pakistan");
        System.out.println(pak);
        System.out.println(pak.getCountry()+" "+pak.getLanguage());
         */
        Locale pak_loc = new Locale("Urdu","Pakistan");
        Locale ind_Loc = new Locale("en", "IN");
        //System.out.println(pak_loc);
        //System.out.println(pak_loc.getCountry()+" "+pak_loc.getLanguage());


        NumberFormat pak = NumberFormat.getCurrencyInstance(pak_loc);
        NumberFormat us     = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india  = NumberFormat.getCurrencyInstance(ind_Loc);
        NumberFormat china  = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: "     + us.format(currency));
        System.out.println("India: "  + india.format(currency));
        System.out.println("China: "  + china.format(currency));
        System.out.println("France: " + france.format(currency));
    }
}