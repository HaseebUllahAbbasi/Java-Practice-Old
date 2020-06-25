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
            System.out.print((i+1)+" Student ID");
            int id = input_int.nextInt();
            System.out.print((i+1)+" Student Name");
            System.out.println();
            String name = input_string.nextLine();
            Module[] modules = new Module[5];
            for(int j=0; j<5; j++)
            {
                modules[j] = new Module();
                modules[j].marks = input_int.nextInt();
                modules[j].calculate();

            }
            students[i] = new Student(id,name,modules);
            students[i].get_gpa();
            System.out.println("=======================================");
        }

    }
}
