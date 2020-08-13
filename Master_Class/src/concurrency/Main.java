package concurrency;

import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();

    }

}
class Message
{
    String message;
    boolean empty = true;
    public synchronized String read()
    {
        while (empty)
        {
            try {
                wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        }
        empty =  true;
        notifyAll();
        return message;
    }
    synchronized void write(String message)
    {
        while (!empty)
        {
            try {
                wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        empty = false;

        this.message = message;
        notifyAll();
    }
}
class Writer implements Runnable
{
    private Message message;

    @Override
    public void run() {
        String messages[] = {"this is message ","to be checked","by the program"};
        Random random = new Random();
        for (int i=0; i< messages.length; i++)
        {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(4000));
            }
            catch (InterruptedException interruptedException)
            {
                interruptedException.printStackTrace();
            }
        }
        message.write("Finished");
    }
    public Writer(Message message)
    {
        this.message = message;
    }
}
class Reader implements Runnable
{
     Message message;
     public Reader(Message message)
     {
         this.message = message;
     }
    @Override
    public void run()
    {
        Random random = new Random();

        for(String  latestMessage = message.read(); !latestMessage.equals("Finished");latestMessage = message.read())
        {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(4000));

            }
            catch (InterruptedException interruptedException)
            {

            }
        }
        // continue from the loop
    }
}

