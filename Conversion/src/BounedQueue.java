/*
Que in java Generics
 
*/

import java.util.Objects;

public class BounedQueue<T> {
    int rear, size, front,no_of_elements;
    T array[];

    public BounedQueue(int size) {
        array = (T[]) new Object[size];
        this.size = size;
        rear = 0;
        front = 0;
        no_of_elements = 0;
    }

    public void enque(T obj)
    {
        if (no_of_elements<size)
        {
            array[front++] = obj;
            no_of_elements++;
        }
        else
            System.out.println("The Queue is full");

    }

    public void deque()
    {
        if (rear < front)
        {
            rear++;
            no_of_elements--;
        }
        else
            System.out.println("Que is already empty");
    }

    public boolean empty()
    {
        if(no_of_elements==0)
            return true;
        else
            return false;
    }
    public boolean full()
    {
        if(no_of_elements==size)
            return true;
        else
            return false;
    }
    public int getNo_of_elements()
    {
        return no_of_elements;
    }
    public int getSize()
    {
        return size;
    }
}
class Main_4
{
    public static void main(String[] args)
    {
        BounedQueue<String> que = new BounedQueue<>(5);
        que.enque("first");
        que.enque("second");
        que.enque("third");
        que.enque("fourth");
        que.enque("fifth");
        que.enque("sixth");
        que.deque();
        que.deque();
        que.deque();

    }
}
