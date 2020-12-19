
public class Simple_Main
{
    public static void main(String[] args)
    {
        Simple_Interface simple_object = new Simple();
        simple_object.call_me_method();

    }
}
class Simple implements Simple_Interface
{
    @Override
    public void call_me_method() {
        System.out.println("call me method is called of the interface");

    }
}
