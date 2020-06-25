/*
Basic OPP Employee Program  
*/

import java.util.Scanner;

public class Ptr_task_simple
{
    public static void main(String[] args)
    {
        Scanner input_int = new Scanner(System.in);
        Scanner input_String = new Scanner(System.in);

        Employee obj = new Employee();
        for (int i=0; i<4; i++)
        {
            int id;
            String name,department;
            double salary;
            System.out.println("Please Enter the Details of the Employee "+(1+i));
            System.out.println("Please Enter the id");
            id = input_int.nextInt();
            System.out.println("Please Enter the name");
            name = input_String.nextLine();
            System.out.println("Please Enter the department");
            department = input_String.nextLine();
            System.out.println("Please Enter the salary");
            salary = input_int.nextDouble();
            System.out.println(obj.hireEmployee(id,name,department,salary));

        }
        System.out.println(obj.findHighestSalary("IT"));

    }
}
class Employee
{
    int nEmployees,ids[];
    double salaries[];
    String names[],departments[];
    Employee()
    {
        nEmployees = 0;
        ids = new int[50];
        salaries = new double[50];
        names = new String[50];
        departments = new String[50];
    }
    public int getnEmployees()
    {
        return nEmployees;
    }
    public boolean hireEmployee(int id,String name,String department,double salary)
    {
        if(nEmployees>=50)
        {
            return false;
        }
        else
        {
            salaries[nEmployees] = salary;
            ids[nEmployees] = id;
            departments[nEmployees] = department;
            names[nEmployees] = name;
            nEmployees++;
            return  true;
        }
    }
    public int findEmployeeByName(String name)
    {
        for(int i=0; i<nEmployees; i++)
        {
            if(names[i].equals(name))
            return 1;
        }
        return -1;
    }
    public int findHighestSalary(String department)
    {
        int index= -1;
        double maxSalary= 0;
        for (int i=0; i<nEmployees; i++)
        {
            if(departments[i].equals(department)&&salaries[i]>maxSalary)
            {
                maxSalary = salaries[i];
                index = i;
            }
        }
        return index;
    }
    public boolean displayEmployee(int index)
    {
        if(index>=nEmployees)
        {
            return false;
        }
        else
        {
            System.out.println("Id : "+ids[index]+", Name : "+names[index]+" Department : "+departments[index]+" Salary : "+salaries[index]);
            return true;
        }
    }
}
