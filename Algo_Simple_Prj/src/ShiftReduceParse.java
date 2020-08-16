public class ShiftReduceParse
{
    String expression;
    String array[];
    int stack_top,max_size;
    ShiftReduceParse(String expression)
    {
        this.expression = expression;
        max_size = 0;
        stack_top = 0;
        array = new String[expression.length()];
        parse();
    }
    private void push(String parentheses)
    {
        array[stack_top++] = parentheses;
    }
    private void pop()
    {
        stack_top--;
    }
    private void parse()
    {
        System.out.println("Parser Output:");
        String exp [] = expression.split(" ");
        boolean operator = true;
        for (String lex: exp)
        {

            if(lex.charAt(0)=='('||lex.charAt(0)=='{'||lex.charAt(0)=='[')
            {
                operator = true;
                push(lex);
                System.out.println("Next Lexeme:" +lex);
            }
            else if(lex.charAt(0)==']'||lex.charAt(0)=='}'||lex.charAt(0)==')')
            {
                System.out.println("Next Lexeme:" +lex);
                if((lex.equals(")")&&get_array_top().equals("("))||(lex.equals("}")&&get_array_top().equals("{"))||(lex.equals("]")&&get_array_top().equals("[")))
                {
                    pop();
                    operator = true;
                }
                else
                    {
                    System.out.println("The Sentance is not Syntactically Correct.");
                    return;
                }
            }
            else if(lex.equals("+")||lex.equals("-")||lex.equals("/")||lex.equals("*"))
            {
                System.out.println("Next Lexeme:" +lex);
                if (operator==false)
                {
                    System.out.println("The Sentence is not Syntactically Correct.");
                    return;
                }
                operator = false;

            }
            else{
                System.out.println("Next Lexeme:" +lex);
                operator = true;
            }

        }
        System.out.println("Next Lexeme: EOF" );
        if(stack_top==0)
        System.out.println("The Sentence is Syntactically Correct");
        else {
            System.out.println("The Sentence is not Syntactically Correct");
        }
    }
    private String get_array_top()
    {
        return array[stack_top-1];
    }
}