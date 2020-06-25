/*
Basic OOP Information Program
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main_1
{
    public static void main(String[] args)
    {
        Scanner input_string = new Scanner(System.in);
        Scanner input_number = new Scanner(System.in);
        ArrayList<Student> database = new ArrayList<>();
        Student student = new Student();
        System.out.println("Instruction to Students");
        System.out.println("***************************");
        System.out.println("Type Your Name With your ID");
        System.out.println("Type Your Semester no & Specialization To Register");
        System.out.println("…………………………………………………");
        System.out.println("Start to fill All detail in the blank Fields given");
        System.out.print("Enter Your Name\t");
        student.name = input_string.next();
        student.roll_no = input_string.next();
        System.out.print("Enter Your Semester\t");
        student.semester = input_number.nextInt();
        System.out.print("Enter Your Specialization\t");
        input_string.nextLine();
        student.specialization = input_string.nextLine();
        System.out.println("***********************************************************");
        System.out.print("Select any Module ::\t");
        student.module_name = input_string.nextLine();
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Module Information report");
        System.out.println("-----------------------------------------------");
        System.out.println("Student Name : \t"+student.name+"\tStudent Roll no:\t"+student.roll_no);
        System.out.println("=========================================================");
        System.out.println("Module : "+student.module_name);
        System.out.println("Module Level : "+0);
        System.out.println("Faculty Name : "+"Ghaniya");
        System.out.println("Number of Assessment : "+"Two Assessments");
        System.out.println("******************** Thank You For Your Register ********************");
        database.add(student);

    }
}
class Student  {
    String name,roll_no,specialization,module_name;
    int semester;
}
