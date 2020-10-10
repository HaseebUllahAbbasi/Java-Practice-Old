class A 
{
    int value = 9;

}
class B extends A
{
    int value = 18;
}
public class Main
{
    public static void main(String... args)
    {
        A obj = new B();
        System.out.println(obj.value);

    }
}