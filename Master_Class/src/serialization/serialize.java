package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class serialize
{
    public static void main(String args[])
    {
            Student obj = new Student(101, 25, "Std_name", "Address_std", 5.6);
            System.out.println(obj.toString());
            try{
                FileOutputStream fos = new FileOutputStream("src/serialization/Student.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(obj);
                oos.close();
                fos.close();
                System.out.println("Serialization is completed");
            }catch(IOException ioe){
                System.out.println(ioe);
            }
        }

}
