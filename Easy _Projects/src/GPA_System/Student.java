public class Student
{
    String id;
    String name;
    Module marks[];

    Student(String id,String name,Module marks[])
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
        double result = sum/50.0;
        System.out.println("The CGPA is "+(Math.round(result*100)/100.0));
    }

}

