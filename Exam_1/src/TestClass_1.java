import java.util.ArrayList;

public class TestClass_1
{
    public static void main(String[] args)
    {
        ArrayList<AbstractEmployee> list = new ArrayList();
        PartTimeEmployee employee_1 = new PartTimeEmployee("1","hob","hr",20,1.5,200);
        PartTimeEmployee employee_2 = new PartTimeEmployee("2","loop","new",40,1.3,200);
        PartTimeEmployee employee_3 = new PartTimeEmployee("3","jack","cs",50,1.9,200);
        list.add(employee_1);
        list.add(employee_2);
        list.add(employee_3);

        for(AbstractEmployee emp:list)
        {
            System.out.println(
                    emp.toString());
        }
    }
}
