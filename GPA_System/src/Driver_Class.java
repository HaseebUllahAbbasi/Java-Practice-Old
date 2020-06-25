import java.util.Scanner;

public class Driver_Class
{
    public static void main(String[] args) {
        Scanner input_int = new Scanner(System.in);
        Scanner input_string = new Scanner(System.in);
        System.out.println("How many Students data you want to enter");
        int get_marks;
        int no_of_student = input_int.nextInt();
        Student[] students = new Student[no_of_student];
        for (int i=0; i<no_of_student; i++)
        {
            System.out.println("Please enter the details of the Student "+(i+1));
            System.out.print("Student Name "+(i+1)+" ");
            String name = input_string.nextLine();
            System.out.print("Student ID "+((i+1))+" ");
            String id = input_string.nextLine();
            System.out.println("Mark of Modules");
            System.out.println("****************************************");
            Module[] modules = new Module[5];
            for(int j=0; j<5; j++)
            {
                modules[j] = new Module();
                System.out.print("Module "+(j+1)+"\t");
                modules[j].marks = input_int.nextInt();
                modules[j].calculate();
            }
            students[i] = new Student(id,name,modules);
            System.out.println("****************************************");
        }
        System.out.println("Details of "+no_of_student+" Students");
        int count_students=1;
        int module = 0;
        for (Student student:students)
        {
            System.out.println("Student Name "+(count_students)+": "+student.name+" Student ID "+count_students+": "+student.id+" Mark of Modules and Grade");
            System.out.println("****************************************");
            System.out.println("Module 1\tModule 2\tModule 3\t\tModule 4\t\tModule 5\t\t");
            for(Module marks:student.marks)
            {
                System.out.print(marks.marks+"\t\t\t");
            }
            System.out.println();
            for(Module marks:student.marks)
            {
                System.out.print(marks.grade+"\t\t\t");
            }
            student.get_gpa();
        }
    }
}
