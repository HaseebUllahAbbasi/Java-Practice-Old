package Students_Marks_System;

public class Student
{
    int id;
    String name;
    Module marks[];

    Student(int id,String name,Module marks[])
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public  void get_gpa()
    {
        double sum = 0;
        for (int i=0; i<5; i++)
        {
            sum+=marks[i].gra_credit;
        }
        System.out.println("The CGPA is"+sum/50);
    }

}

