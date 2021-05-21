   package sample_9;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sample_9.Sample_9.exit;
import static sample_9.Sample_9.input;
import static sample_9.Sample_9.login;

public class Sample_9 
{
     
    static Scanner  input = new Scanner(System.in);
    public static String firstName,lastName;
    static void menu()
    {
        System.out.println("*** Welcome to Library Management System (LMS) ***\n");
        System.out.println("1: Login");
        System.out.println("2: Logout\n");
        
    }
    public static void main(String args[]) throws Exception
    {
        menu();
        System.out.print(">");
        int choice = input.nextInt();
        if(choice==1)
            Operation();
        else
            exit();
    }
    public static void login()  throws Exception
    {

        System.out.println("*** LMS :: Login ***\n");
        System.out.print("Enter username>");
        String username=input.next();
        System.out.print("Enter password>");
        String password=input.next();
        
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/drrsdbs","root","");  
        Statement stmt = null;  
        stmt = connection.createStatement();
        ResultSet result_set;  
        result_set = stmt.executeQuery("select firstName,lastName,userName,password from staff");
        boolean flag=true;
        while(result_set.next())
        {
            if(result_set.getString(3).equals(username) && result_set.getString(4).equals(password))
            {
                firstName=result_set.getString(1);
                lastName=result_set.getString(2);
                System.out.println("Login successful!");
                options(new String(firstName+" "+lastName));
                flag=false;
            }            
        }
            //System.out.println(result_set.getInt(1)+"  "+result_set.getString(2)+"  "+result_set.getString(3) + " "+result_set.getString(4) );  
        
        result_set.close();
        connection.close();
        if(flag)
        {
            System.out.println("Entered username or password is wrong!");
            login();
        }
        
        
    }

    public static void options(String name)  throws Exception
    {   
        System.out.println("*** Library Management System (LMS) ***\n");
        System.out.println("You are login as  "+name+"\n");
        System.out.println("1: Library Operation");
        System.out.println("2: Logout\n"); 
        System.out.print(">");
        int choice = input.nextInt();
        if(choice==1)
            Operation();
        else
            exit();
        
    }
    static void Operation() throws Exception 
    {
        System.out.println("*** LMS :: Library Operation ***\n");
        System.out.println("1: Register Member");
        System.out.println("2: Lend Book");
        System.out.println("3: View fine amount");
        System.out.println("4: Return Book");
        System.out.println("5: Back\n");
        while(true)
        {
            System.out.print(">");
            int choice = input.nextInt();
        if(choice==1)
            register();
        else if(choice==2)
            lend_book();
        else if(choice==3)
            view_fine();
        else if(choice==4)
            return_book();
        else if(choice==5)
            options(firstName+" "+lastName);
        else 
            System.out.println("please enter the listed commands");
        }
        
        
    }
    static void register() throws  Exception
    {
        System.out.println("*** LMS :: Library Operation :: Register Member ***\n");
        System.out.print("Enter First Name> ");
        String first_name = input.next();
        System.out.print("Enter Last Name>");
        String last_name = input.next();
        System.out.print("Enter Gender>");
        char gender = (input.next()).charAt(0);
        System.out.print("Enter Age> ");
        int age = input.nextInt();
        System.out.print("Enter Identity Number> ");
        String id_number = input.next();
        System.out.print("Enter Phone> ");
        String phone_no = input.next();
        System.out.print("Enter Address> ");
        String address = input.next();
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/drrsdbs","root","");  
        Statement stmt = null;  
        stmt = connection.createStatement();
        ResultSet result_set;  
        stmt.execute("INSERT INTO member(firstName,lastName,gender,age,identity,phone,address) VALUES ('"+first_name+"','"+last_name+"','"+gender+"',"+age+",'"+id_number+"','"+phone_no+"','"+address+"');");
        //result_set = stmt.executeQuery("INSERT INTO member(firstName,lastName,gender,age,identity,phone,address) VALUES ('"+first_name+"','"+last_name+"','"+gender+"',"+age+",'"+id_number+"','"+phone_no+"','"+address+"');");
        
//        while(result_set.next())  
//            System.out.println(result_set.getInt(1)+"  "+result_set.getString(2)+"  "+result_set.getString(3) + " "+result_set.getString(4) );  
//        result_set.close();
//        connection.close();
        if(true)
        {
            System.out.println("Member has been registered successfully!");
            Operation();
        }
        connection.close();
        
        
    }
    static void lend_book() throws BookNotFoundException, Exception
    {
         Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/drrsdbs","root","");  
        Statement stmt = null;  
        stmt = connection.createStatement();
        ResultSet result_set;  
        
        System.out.println("*** LMS:: Library Operation :: Lend Book ***\n");
        System.out.print("Enter Book Id>");
        int id = input.nextInt();
        
         result_set=stmt.executeQuery("SELECT title From book WHERE bookId="+id+";");
        
        String title;
        if(result_set.next())
        {
            title = result_set.getString(1);
        }
        else
        {
            throw new BookNotFoundException("Invalid bookId");
        }
        
        System.out.print("Enter Member Identity Number>");
        String identity = input.next();
   
       
  
        //check whether book is present or not 
       
        
        result_set=stmt.executeQuery("SELECT memberId,firstName,lastName From member WHERE identity='"+identity+"'; ");
        result_set.next();
        int memberid= result_set.getInt(1);
        String fname = result_set.getString(2);
        String lname = result_set.getString(3);
        stmt.execute("INSERT INTO lendandreturn(memberId,bookId,lendDate,returnDate,fineAmount) VALUES("+memberid+","+id+",DATE_FORMAT(CURRENT_TIMESTAMP(), \"%Y-%m-%d %k:%S\"),NULL,0);");
        //result_set = stmt.executeQuery("Select b.title, mem.firstName,mem.lastName FROM member mem JOIN book b ON b.bookId=mem.bookId");
        
        //result_set.close();
        

        System.out.println("Book: "+title+" lent to "+fname+" "+lname+"");
        result_set.close();
        connection.close();
        Operation();
    }
    static void view_fine() throws Exception
     {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/drrsdbs","root","");  
        Statement stmt = null;  
        stmt = connection.createStatement();
        ResultSet result_set;  
        
         System.out.println("*** LMS:: Library Operation :: View fine amount ***\n");
         System.out.print("Enter Lend Id> ");
         int lendid = input.nextInt();
         result_set =stmt.executeQuery("SELECT mem.firstName,mem.lastName,lar.fineAmount FROM member mem INNER JOIN lendandreturn lar ON mem.memberId=lar.memberId WHERE lar.lendId="+lendid+";");
         int famount;
         if(result_set.next())
         {
             String fname=result_set.getString(1);
             String lname=result_set.getString(2);
             famount= result_set.getInt(3);
             System.out.println(fname+" "+lname+" is fined with "+famount+" $");
        }
         else
             throw new LendingNotFoundException("Invalid lendId");
         result_set.close();
         connection.close();
         Operation();
         
        //prints the reuslt of the id  or  throws the exception 
    }
   static void return_book() throws Exception
   {
       Class.forName("com.mysql.jdbc.Driver");
       Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/drrsdbs","root","");  
       Statement stmt = null;  
       stmt = connection.createStatement();
       ResultSet result_set; 
       
       System.out.println("*** LMS:: Library Operation :: Return Book ***\n");
       System.out.print("Enter Lend Id> ");
       int lendid = input.nextInt();
       result_set =stmt.executeQuery("SELECT * FROM lendandreturn WHERE lendId="+lendid+";");
       if(!result_set.next())
       {
           throw new LendingNotFoundException("Invalid lendId");
       }
       //entering returnDate into lendandreturn table 
       result_set = stmt.executeQuery("SELECT DATEDIFF(SELECT lendDate from lendandreturn where lendId="+lendid+",CURRENT_TIMESTAMP());");
       result_set.next();
       int days=result_set.getInt(1);
       int fineamount = 0;
       if(days>14)
       {
           fineamount += (days-14)*50;
       }
       //retrive fine 
       
       System.out.print("Enter fine amount paid>");
       int fpaid = input.nextInt();
       
       //check if the entered paid amount is equal to fine amount  
       if(fineamount==fpaid)
       {
           result_set =stmt.executeQuery("SELECT b.title, mem.firstName,mem.lastName FROM lendandreturn lar JOIN member mem ON lar.memberId=mem.memberId JOIN book b ON b.bookId=lar.bookId WHERE lendId="+lendid+";");
           result_set.next();
           System.out.println("Book: "+result_set.getString(1)+" is successfully retuned by "+result_set.getString(2)+" "+result_set.getString(3)+".");
       }
       else
       {
           throw new FineNotPaidException("Total fine is not paid : Book Not Returned");
       }
       
       stmt.execute("INSERT INTO lendandreturn(returnDate) VALUES (DATE_FORMAT(CURRENT_TIMESTAMP(), \"%Y-%m-%d %k:%S\")) WHERE lendId="+lendid+";");
       result_set.close();
       connection.close();
       Operation();
       
   }


   public static void exit()
   {
       System.exit(0);
   }

    
}
