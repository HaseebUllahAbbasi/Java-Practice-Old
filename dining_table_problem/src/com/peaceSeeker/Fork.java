package com.peaceSeeker;
import java.util.Random;
public class Fork
{
    protected int fork_id;
    private boolean status;
    Fork(int fork_id)
    {
        this.fork_id = fork_id;
        this.status = true;
    }
    public synchronized void free() throws InterruptedException
    {
        status = true;
    }
    public synchronized boolean pick(int philosopherId) throws InterruptedException{

        int counter = 0;
        int waitUntil = new Random().nextInt(5)+5;

        while(!status){
            Thread.sleep(new Random().nextInt(100)+50);

            counter++;

            if(counter>waitUntil){
                return false;
            }
        }
        status = false;
        return true;
    }

}
