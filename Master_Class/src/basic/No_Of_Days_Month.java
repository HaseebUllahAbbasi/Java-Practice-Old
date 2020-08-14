package basic;

import java.util.Scanner;

public class No_Of_Days_Month
{
    public static boolean isLeapYear(int year){
        if(year < 1 || year > 9999)
        {
            return false;
        }
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
    public static int getDaysInMonth(int month, int year)
    {
        if(month < 1 || month > 12 || year < 1 || year > 9999)
        {
            return -1;
        }
        if(month == 2)
        {
            return isLeapYear(year) ? 29 : 28;
        }
        switch(month)
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return -1;
        }
    }
    public static int sumFirstAndLastDigit(int number)
    {
        int lastDigit = number % 10;
        int firstDigit = 0;
        if(number < 0) return -1;
        while (number != 0)
        {
            firstDigit = number % 10;
            number /= 10;
        }
        return firstDigit + lastDigit;
    }

    public static int getLargestPrime(int number){
        if (number < -1) return -1;
        for(int i = number; number > 1; i--){
            boolean isPrime = true;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && number % i == 0){
                return i;
            }
        }
        return -1;
    }
    /*
    Palindrome of a  number in check
    // return reverse as the reverse of the number
     */
        public static boolean isPalindrome(int number)
        {
            int original = number;
            int reverse = 0;
            while (number != 0){
                int lastDigit = number % 10;
                number /= 10;
                reverse = reverse * 10 + lastDigit;
            }
            return(original == reverse);
        }

    public static void main(String[] args)
    {
        Scanner input  = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        System.out.println(        getDaysInMonth(month,year));
    }

}
