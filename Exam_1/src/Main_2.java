import sun.applet.Main;

import java.util.Arrays;
import java.util.Random;

public class Main_2
{
    private int[] rand_numbers = new int[16];

    public static void main(String[] args) {
        (new Main_2()).generate_numbers();
    }
    private void generate_numbers()
    {

        int index = 0;
        int max = 9;
        int min = 1;
        Random random = new Random();
        boolean completed = false;
        while (!completed)
        {
            if(index==16)
                completed = true;
            int number =  random.nextInt(max - min) + min;
            if(checkNumber(number))
            {
                rand_numbers[index++] = number;
            }
            System.out.println(Arrays.toString(rand_numbers));
        }
    }

    private boolean checkNumber(int number)
    {
        int counter = 0 ;
        for(int num:rand_numbers)
        {
            if(number==num)
                counter++;
        }
        return counter <2;
    }

}
