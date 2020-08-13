package hackerRank.stack_prob;

public class Main
{
    public static void main(String[] args)
    {


        String expressions[] = {"a","b"};
        int size = expressions.length;
        Stack[] stacks = new Stack[size];
        int index = 0;
        for (String expression:expressions)
        {

            for (char character:expression.toCharArray())
            {
                 stacks[index].push(character);
            }

        }

    }
}
class Node
{
    char value;
    Node next;
    Node prev;
    public Node(char value)
    {
        this.value = value;
        next = null;
    }
}
class Stack
{
    Node head;
    Node tail;
    int size;
    Stack()
    {
        size = 0;
        head = null;
    }
    void push(char value)
    {
        Node new_node = new Node(value);
        if(head==null)
        {
            head = new_node;
            tail = new_node;
        }
        else
        {
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
        }
        size++;
    }
    void pop()
    {
        if(head!=null)
        {

            Node temp = head.next;
            temp.prev = null;
            temp.next = null;
        }
    }
    boolean check()
    {
        return size==0;
    }
}
