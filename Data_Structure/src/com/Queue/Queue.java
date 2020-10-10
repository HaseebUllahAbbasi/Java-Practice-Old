package com.Queue;

import com.linked_list.Link;

public class Queue
{
    private Link head;
    private Link tail;
    private int size;
    Queue()
    {
        size =0;
        head = null;
        tail = null;
    }
    public void enqueue(Link node)
    {
        if(head==null&&tail==null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
        }
        size++;
    }
    public Link dequeue()
    {
        size--;
        if(head!=null&&tail!=null)
        {
            Link node = head;
            head = head.next;
            return node;
        }
        else
        {
            return null;
        }

    }
    public int size()
    {
        return size;
    }
}
