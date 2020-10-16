package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class de_serialize
{
        public static void main(String args[])
        {
            Student object=null;
            try{
                FileInputStream fileInputStream = new FileInputStream("src/serialization/Student.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                object = (Student)objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            }
            catch(IOException exception)
            {
                exception.printStackTrace();
                return;
            }
            catch(ClassNotFoundException exception)
            {
                System.out.println("Student Class is not found.");
                exception.printStackTrace();
                return;
            }
            System.out.println("Student Name:"+object.getStuName());
            System.out.println("Student Age:"+object.getStuAge());
            System.out.println("Student Roll No:"+object.getStuRollNum());
            System.out.println("Student Address:"+object.getStuAddress());
            System.out.println("Student Height:"+object.getStuHeight());
        }

}
