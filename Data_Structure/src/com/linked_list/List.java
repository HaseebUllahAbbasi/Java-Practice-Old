package com.linked_list;
public class List
{
    Link head,tail;
    List()
    {
        head = null;
        tail = null;
    }
    protected void insert_at_head(int data)
    {
        Link obj = new Link(data);
        if(head==null)
        {
            head = obj;
            tail = obj;
        }
        else
        {
            obj.next = head;
            head = obj;
        }
    }
    public void add(int data)
    {
        insert_at_tail(data);
    }
    protected void insert_at_tail(int data)
    {
        Link obj = new Link(data);
        if(head==null)
        {
            head = obj;
            tail = obj;
        }
        else
        {
            tail.next = obj ;
            tail = obj;
        }
    }
    public void print()
    {
        Link current = head;
        while (current!=null)
        {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println("\n printed all the data");
    }
    public void delete_head()
    {
        if(head==null)
        {
            return;
        }
        else {
            Link current = head;
            head  = head.next;
            current = null;
        }
    }
    public void delete_tail()
    {
        if(head==null)
            return;
        {
            Link current = head;
            Link temp = head;
            while (current.next!=tail)
            {
                temp = current;
                current = current.next;
            }
            tail = current;
            current.next  = null;
        }
    }
    public void delete_element(int data)
    {
        Link current = head;
        Link prev = null;

    }


}

