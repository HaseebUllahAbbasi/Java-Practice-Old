package hackerRank.JavaBasic.task_3;

import java.util.*;
import java.util.Scanner;

class Parser
{


    public boolean isBalanced(String next)
    {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<next.length(); i++)
        {
            if(stack.empty())
            {
                stack.push(next.charAt(i));
                continue;
            }
            if(next.charAt(i)=='(' || next.charAt(i)=='{'  || next.charAt(i)=='[')
                stack.push(next.charAt(i));
            else if(next.charAt(i)==')')
            {
                if(stack.peek()=='(')
                    stack.pop();
                else return false;
            }
            else if (next.charAt(i)=='}')
            {

                if(stack.peek()=='{')
                    stack.pop();
                else return false;

            }
            else if( next.charAt(i)==']')
            {

                if(stack.peek()=='[')
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.empty();
    }
}
// Write your code here. DO NOT use an access modifier in your class declaration.
class Solution {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();
    }
}
