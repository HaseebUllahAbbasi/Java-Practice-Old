package thirty_days;
import java.util.*;

class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + 	"\nID: " + idNumber);
    }

}

class Student extends Person{

    private int[] testScores;

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    Student(String name,String last_name,int id,int[] test_score)
    {
        super(name,last_name,id);
        this.testScores = test_score;
    }

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    public char calculate()
    {
        char grade = '0';
        int sum = 0;
        for(int score:testScores)
            sum+=score;

        double avg = sum/testScores.length;

        if(avg>=90.0&&avg<=100.00)
            grade = 'O';
        else if(avg>=80.0&&avg<90.0)
            grade = 'E';
        else if(avg>=70.0&&avg<80.0)
            grade = 'A';
        else if(avg>=55.0&&avg<70.0)
            grade = 'P';
        else if(avg>=40.0&&avg<55.0)
            grade = 'D';
        else if(avg>0.0&&avg<40.0)
            grade = 'T';

        return //"Name: "+super.firstName+", "+super.firstName+"\n"
                //+" ID: "+super.idNumber+"\n"+
                grade;
    }
}

class Solution_2
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for(int i = 0; i < numScores; i++){
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate() );
    }
}