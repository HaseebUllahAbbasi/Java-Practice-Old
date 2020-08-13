package hackerRank.stack_prob;

public class Main_2
{
    public static void main(String[] args)
    {
        String[] expressions = {"{}()","({()})","{}(","[]"};
        int size = expressions.length;
        Stack_1[] stacks = new Stack_1[size];
        int index = 0;
        for (String expression:expressions)
        {
            stacks[index] = new Stack_1(expression);
            for(int i=0; i<expression.length(); i++)
            {
                if(expression.charAt(i)=='('||expression.charAt(i)=='{'||expression.charAt(i)=='[')
                {
                    stacks[index].push(expression.charAt(i));
                }
                else if(expression.charAt(i)==')'||expression.charAt(i)=='}'||expression.charAt(i)==']')
                {
                    stacks[index].pop();
                }
            }
            System.out.println(stacks[index].is_balance());
        }
    }
}
class Stack_1
{
    int maxSize,stackTop;
    char[] Array;
    Stack_1(String str)
    {
        maxSize = str.length();
        stackTop=0;
        Array=new char[maxSize];
    }
    void push(char character)
    {
        Array[stackTop++] = character;
    }
    void pop()
    {
        stackTop--;
    }
    boolean is_balance()
    {
        return(stackTop==0);
    }
}

