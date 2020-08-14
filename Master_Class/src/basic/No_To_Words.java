package basic;
public class No_To_Words
{
    public static int getDigitCount(int number)
    {
        if (number < -1) return -1;
        if (number == 0 ) return 1;
        int count = 0;
        while (number > 0)
        {
            count += 1;
            number /= 10;
        }
        return count;
    }
    public static int reverse(int number)
    {
        int new_num = 0;
        while (number != 0){
            int lastDigit = number % 10;
            number /= 10;
            new_num = new_num * 10 + lastDigit;
        }
        return new_num;
    }

    public static void numberToWords(int number)
    {
        if (number < 0) System.out.println("Invalid Value");
        int rev = reverse(number);
        int temp = rev;
        int value = 0;
        while (temp != 0)
        {
            int digit = temp % 10;
            if(digit == 0) System.out.println("Zero");
            else if (digit == 1) System.out.println("One");
            else if (digit == 2) System.out.println("Two");
            else if (digit == 3) System.out.println("Three");
            else if (digit == 4) System.out.println("Four");
            else if (digit == 5) System.out.println("Five");
            else if (digit == 6) System.out.println("Six");
            else if (digit == 7) System.out.println("Seven");
            else if (digit == 8) System.out.println("Eight");
            else if (digit == 9) System.out.println("Nine");
            temp /= 10;
        }
        int zeroDigit = getDigitCount(number)- getDigitCount(rev);
        String finalPrint = "";
        for(int i=0; i<zeroDigit; i++)
        {
            finalPrint +="Zero\n";
        }

        System.out.print(finalPrint);
    }
    public static void main(String[] args)
    {
        numberToWords(109);
    }
}