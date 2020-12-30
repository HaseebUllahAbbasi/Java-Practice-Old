package object_limit;


public class LimitObjectCreationTest
{

    public static void main(String[] args) {

        LimitClass obj;
        int i=1;
        while(i<=20)
        {
            obj = LimitClass.getLimInstance();
            i++;
        }
    }
}


