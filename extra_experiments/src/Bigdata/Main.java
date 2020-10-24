package Bigdata;

import java.math.BigInteger;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /*
        Scanner input = new Scanner(System.in);
        int number_input = input.nextInt();
        boolean check = true;
        BigInteger Big_Number  = new BigInteger(String.valueOf(number_input));
        for (BigInteger i = new BigInteger(String.valueOf(2)); i. <number_input; i++)
        {
            BigInteger divider = new BigInteger(String.valueOf(i));
            //System.out.println("divider is "+divider.toString()+", the big number is  "+Big_Number.toString());
            if((Big_Number.mod(divider).equals(new BigInteger(String.valueOf(0)))))
            {
                System.out.println("not prime");
                check = false;
                break;

            }
        }
        if(check)
        {
            System.out.println("prime");
        }

         */
            try (Scanner scanner = new Scanner(System.in);)
            {
                System.out.println(scanner.nextBigInteger().isProbablePrime(100) ? "prime" : "not prime");
            }

    }

}
