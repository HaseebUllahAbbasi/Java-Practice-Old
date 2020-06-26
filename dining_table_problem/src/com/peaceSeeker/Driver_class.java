package com.peaceSeeker;
import java.util.Scanner;

public class Driver_class
{
    Philosopher[] philosophers;
    Fork[] forks;
    Thread[] threads;

    Scanner input;
    int number_of_ph;
    public void initialize()
    {

        input = new Scanner(System.in);
        System.out.println("Dining Philosopher Assignment");
        try
        {
            System.out.println("Write the number of Philosophers: ");
            number_of_ph=input.nextInt();
            if(number_of_ph<2)
            {
                System.out.println("Number should be greater than 1.");
                return;
            }
        }
        catch(Exception e)
        {
            System.out.println("Please enter the number .");
        }
        philosophers=new Philosopher[number_of_ph];
        forks=new Fork[number_of_ph];
        threads=new Thread[number_of_ph];

        for (int i=0;i<number_of_ph; i++){

            philosophers[i]=new Philosopher(i+1);
            forks[i]=new Fork(i+1);

        }

    }

    public void startThinkingEating()
    {

        for(int i=0;i<number_of_ph;i++)
        {
            final int index=i;
            threads[i]=new Thread(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        philosophers[index].start(forks[index],(index-1>0)? forks[index-1]:forks[number_of_ph-1]);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
    }
}
