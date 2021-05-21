package sami_exam;

class Link
{
    int data;
    public Link next;
    public Link(int data)
    {
        this.data = data;
        this.next = null;
    }
}
class List
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
    List intersection(List l1, List l2)
    {
        List same = new List();
        Link node_1 = l1.head;
        Link node_2 = l2.head;
        Link new_result = l2.head;

        int count =0 ;

        if(node_1 !=null && node_2 !=null )
        {
            if(node_1.data == node_2.data)
            {
                if(count==0)
                {
                    same.head = new Link(node_1.data);

                    count++;
                }
                else
                {
                    same.add(node_1.data);
                }
            }
            node_2 =  node_2.next;
            node_1 =  node_1.next;

        }

    return same;
    }

}
