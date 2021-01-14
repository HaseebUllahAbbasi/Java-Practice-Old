package Simple.Ayesha;
import java.util.Scanner;

public class Java extends JAVATutorial
{

    public void SetJAVA() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Why learn JAVA programming: ");
        String aJAVA = scan.nextLine();
        System.out.println("Platform Independent,simple,secure,Object Oriented:" + aJAVA);
    }

    public void JAVAList()
    {

        System.out.println("(Java Object Oriented)");
        System.out.println("1.Java Inheritance \n2.Java Overriding \n3.Java Polymorphism \n4.Java Abstraction \n5.Java Encapsulation");
        super.JAVAList();
    }
}