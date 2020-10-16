package lambda;


import static java.lang.System.out;

public class Main
{

    public static void main(String args[])
    {
        // lambda expression to implement above
        // functional interface. This interface
        // by default implements abstractFun()
        FuncInterface fobj = (int x)-> out.println(2*x);

        // This calls above lambda expression and prints 10.
        fobj.abstractFun(5);
    }

}
