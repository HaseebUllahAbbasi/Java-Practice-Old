public class TestClass_3
{
    public static void main(String[] args) throws CloneNotSupportedException {
        Office office = new Office("12","MRC building");

        Employee employee = new Employee("1","hob",office);
        Employee employee_1 = (Employee) employee.clone();
        employee_1.name = "new name";
        System.out.println(employee_1);
        System.out.println(employee);

    }
}
