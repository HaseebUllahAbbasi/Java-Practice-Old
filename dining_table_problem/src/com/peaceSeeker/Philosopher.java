package com.peaceSeeker;
import java.util.Random;

public class Philosopher
{
    private int philosopher_id;
    private Fork left, right;
    private int satisfaction;

    Philosopher(int philosopher_id)
    {
        satisfaction = 1;
        this.philosopher_id=philosopher_id;
    }

    public void start(Fork left,Fork right) throws InterruptedException
    {
        this.left=left;
        this.right=right;
        while(satisfaction<=2)
        {
            if(new Random().nextBoolean())
            {
                eat();
            }else
                {
                think();
            }
        }
    }

    public void think() throws InterruptedException{

        System.out.println("The Philosopher: "+philosopher_id+" is now thinking");
        Thread.sleep(new Random().nextInt(100)+1000);
        System.out.println("The Philosopher : "+ philosopher_id+" has stopped thinking");

    }

    public void eat() throws InterruptedException
    {

        boolean right_pick = false;
        boolean left_pick = false;

        System.out.println("The philosopher : " + philosopher_id + " is going to eat");

        System.out.println("The philosopher : " + philosopher_id + " has picked fork: " + (left.fork_id));
        left_pick = left.pick(philosopher_id);

        if (!left_pick)
        {
            return;
        }
        System.out.println("The philosopher : " + philosopher_id + " has picked fork: " + right.fork_id);
        right_pick = right.pick(philosopher_id);
        if (!right_pick)
        {
            left.free();
            return;
        }

        System.out.println("The philosopher : " + philosopher_id + " is eating ");

        Thread.sleep(new Random().nextInt(100) + 100);
        left.free();
        right.free();

        System.out.println("The philosopher : " + philosopher_id + " has finished eating and has made the forks free and has eaten "+(satisfaction));
        satisfaction++;

    }


}