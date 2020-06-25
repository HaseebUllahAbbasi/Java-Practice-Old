/*
Basic OOP student Information program
*/

import java.util.Scanner;

public class Main_2
{
    public static void main(String[] args)
    {
        Scanner input_String = new Scanner(System.in);
        Scanner input_int = new Scanner(System.in);

        Student array[] = new Student[10];
        int seriel =10;
        for (int i=0; i<10; i++)
        {
            System.out.println("Please enter the name of the Student with Serial :"+seriel);
            array[i] = new Student();
            array[i].seriel = seriel;
            array[i].name = input_String.nextLine();
            seriel++;
        }
        System.out.println("Registration is finished");
        int loop = 1;
        while(loop==1)
        {
            System.out.println("Please enter the any of the choice");
            System.out.println("1 :Search any Student");
            System.out.println("or press any other key to exit");


            int select = input_int.nextInt();
            switch(select)
            {
                case 1:
                    String name = input_String.nextLine();
                    Main_2.Search(array,name);

                    break;
                default:
                    loop+=1;
                    break;
            }
        }
    }
    public static void Search(Student array[],String name)
    {
        int found = 0;
        for (Student obj:array)
        {
            if(obj.name.equals(name))
            {
                System.out.println(obj);
                found+=1;
                break;
            }
        }
        if(found==0)
        {
            System.out.println(name+" Not Found");
        }
    }
}
class Student
{
    int seriel;
    String name;
    @Override
    public String toString() {
        return "" +
                "seriel=" + seriel +
                ", name=" + name + '\n' ;
    }
}
