public class Module
{
    String module_name,grade;
    int marks,credit=10;
    double gpa, gra_credit;
    public void calculate()
    {
        if(marks>=91&&marks<=100)
        {
            grade = "A";
        }
        else if(marks>=87&&marks<=90)
        {
            grade = "A-";
        }
        else if(marks>=84&&marks<=86)
        {
            grade = "B+";
        }
        else if(marks>=80&&marks<=83)
        {
            grade = "B";
        }
        else if(marks>=77&&marks<=79)
        {
            grade = "B-";
        }
        else if(marks>=74&&marks<=76)
        {
            grade = "C+";
        }
        else if(marks>=70&&marks<=73)
        {
            grade = "C";
        }
        else if(marks>=66&&marks<=69)
        {
            grade = "C-";
        }
        else if(marks>=60&&marks<=65)
        {
            grade = "D+";
        }
        else if(marks>=58&&marks<=64)
        {
            grade = "D";
        }
        else if(marks>=50&&marks<=57)
        {
            grade = "D-";
        }
        else if(marks>=0&&marks<=49)
        {
            grade = "F";
        }
        assign_gpa();
    }
    void assign_gpa()
    {
        if(grade.equals("A"))
            gpa = 4.0;
        else if (grade.equals("A-"))
            gpa = 3.67;
        else if (grade.equals("B+"))
            gpa = 3.33;
        else if (grade.equals("B"))
            gpa = 3.00;
        else if (grade.equals("B-"))
            gpa = 2.67;
        else if (grade.equals("C+"))
            gpa = 2.33;
        else if (grade.equals("C"))
            gpa = 2.0;
        else if (grade.equals("C-"))
            gpa = 1.67;
        else if (grade.equals("D+"))
            gpa = 1.33;
        else if (grade.equals("D"))
            gpa = 1.0;
        else if (grade.equals("D"))
            gpa = 0.7;
        else if (grade.equals("F"))
            gpa = 0;
        assign_total();
    }
    void assign_total()
    {
        gra_credit = gpa * credit;
    }


}
