package com.Queue;

import com.linked_list.Link;

public class Queue
{
    Link head;
    Link tail;
    Queue()
    {
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
    }
    public Link dequeue()
    {
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
}
