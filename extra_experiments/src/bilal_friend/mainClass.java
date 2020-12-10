package bilal_friend;

import java.util.*;
class studentData
{

    String name;
    int id;
    private String grade, percentage;
    private int semesterCreditHours;
    private double cgpa;
    private int numOfCourses;
    private String coursesArr[];
    private static int perCreditHour = 4500;
    static int numOfStudents=0;

    studentData(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
    public void setCgpa(double cgpa){
        if(cgpa>=0 && cgpa<=4){
            this.cgpa = cgpa;
        }
        else{
            System.out.println("Enter Valid CGPA");
        }

    }
    public void setPercentage(String percentage){
        this.percentage = percentage;
    }

    public String getPercentage(){
        return this.percentage;
    }
    public void setCourses()
    {
        System.out.println("Enter num of courses");
        Scanner sc= new Scanner(System.in);
        Scanner sc2= new Scanner(System.in);
        int no =sc.nextInt();
        coursesArr = new String[no];
        for(int i=0; i<no; i++)
        {
            System.out.println("Enter name of course "+ i);
            coursesArr[i] = sc2.nextLine();
        }
    }


    public void setSemesterCreditHours(int val){
        this.semesterCreditHours = val;
    }
    public int getSemesterCreditHours(){
        return semesterCreditHours;
    }


    public double feeCalculator(){
        return perCreditHour*numOfCourses;
    }

    public double feeAfterScholorship()
    {
        double fee=0;
        if(this.cgpa==0 || this.cgpa<3.5)
        {
            System.out.println("You are not applicable for scholorship for the Upcomming semester and you have to pay fess");
        }
        else if(this.cgpa==4)
        {
            fee = 0;
        }
        else if(this.cgpa>3.75)
        {
            fee= (feeCalculator()*0.25);
        }
        else if(this.cgpa==3.5)
        {
            fee= (feeCalculator()*0.5);
        }
        else
        {
            fee= feeCalculator();
        }
        return fee;
    }

    public String getGrade()
    {
        String str="";
        switch(this.grade)
        {

            case "A":
            case "a":
                str= grade+" Excellent";
                break;
            case "B+":
            case "b+":
                str= grade+" Very Good";
                break;

            case "B":
            case "b":
                str =grade+" Good";
                break;

            case "C+":
            case "c+":
                str =grade+" Average";
                break;

            case "C":
            case "c":
                str =grade+" Below Average";
                break;

            case "F":
            case "f":
                str =grade+" Failure(Course repeat)";
                break;
            case "I":
            case "i":
                str =grade+" Incomplete";
                break;
            case "W":
            case "w":
                str =grade+" Withdrawal";
                break;
            case "K":
            case "k":
                str =grade+" Course in progress";
                break;
            default:
                str="Invalid grade";
                break;
        }
        return str;
    }


    public void setGrade(String grade){
        this.grade = grade;
    }

}



public class mainClass
{

    public static studentData[] stdArray;
    public static int noOfStudents;
    public static void main(String args[])
    {

        System.out.println("Enter number of students: ");
        Scanner sc= new Scanner(System.in);
        Scanner sc2= new Scanner(System.in);
        noOfStudents = sc.nextInt();
        stdArray = new studentData[noOfStudents];
        for(int i=0; i<noOfStudents; i++)
        {
            System.out.println("Enter Name: ");
            String name = sc2.nextLine();
            System.out.println("Enter ID: ");
            int id = sc.nextInt();
            studentData obj = new studentData(name,id);
            add(obj);
        }




    }
    public void listOfStudentsInOrder()
    {
        int n = studentData.numOfStudents;
        studentData[] arr = new studentData[50];
        int temp = 0;
        for(int i=0; i < n; i++)
        {
            for(int j=1; j < (n-i); j++)
            {
                if(arr[j-1].id > arr[j].id)
                {

                    temp = arr[j-1].id;
                    arr[j-1].id = arr[j].id;
                    arr[j].id = temp;
                }

            }
        }
        for(int k=0; k<studentData.numOfStudents; k++)
        {
            System.out.println("Name: "+ stdArray[k].name+" ID: "+stdArray[k].id);
        }
    }
    public static void add(studentData obj)
    {
        stdArray[studentData.numOfStudents++] = obj;
    }


}





   