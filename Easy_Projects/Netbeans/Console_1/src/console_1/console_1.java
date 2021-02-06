package console_1;

import java.sql.*;
import java.util.Scanner;

public class console_1
{
    public static void main(String[] args) throws SQLException, Input_Exception, Exception
    { // this is  he method to be used for thr both of the optons
        int end = 0;
        Luxury_Double_Room luxury_double_room = new Luxury_Double_Room();
        Deluxe_Double_Room deluxe_double_room = new Deluxe_Double_Room();
        Luxury_Single_Room luxury_single_room = new Luxury_Single_Room();
        Deluxe_Single_Room deluxe_single_room = new Deluxe_Single_Room();
        
        
        Scanner input = new Scanner(System.in);
        while (true) // runs unitl the user hits exit or input a new number that does not exist in the list
        {
            System.out.println("Please Enter your choice: \n1. Customer View \n2. Receptionist View\n3. Close Application");
            int choice = input.nextInt();
            if(choice==1) // condition for the customer view 
            {
                System.out.println("Welcome to the Customer View");
                while (true) //runs unitl the user hits exit or input a new number that does not exist in the list
                {
                    customer_view(); // view the menu of the customer
                    System.out.println("selection any option");
                    choice = input.nextInt();
                    if(choice==1) 
                    {
                        room_type(); // view room type 
                        choice  = input.nextInt(); 
                        if(choice==1) // if selected  one 
                        {
                            luxury_double_room.display_detail();
                        }
                        else if(choice==2)
                        {
                            deluxe_double_room.display_detail();
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.display_detail();
                        }
                        else if(choice==4)
                        {
                            deluxe_single_room.display_detail();
                        }
                        else 
                        {
                            throw new Input_Exception("Bad input : Closing Application");
                        }
                    }
                    else if(choice==2)
                    {
                        room_type();
                        choice  = input.nextInt(); 
                        if(choice==1) 
                        {
                            luxury_double_room.availability();
                        }
                        
                        else if(choice==2)
                        {
                            deluxe_double_room.availability();
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.availability();
                        }
                        else if(choice==4)
                        {
                            deluxe_single_room.availability();
                        }
                        else 
                        {
                            throw new Input_Exception("Bad input : Closing Application");
                        }
                    }
                    else if(choice==3) 
                    {
                        room_type();
                        choice  = input.nextInt();  
                        if(choice==1) 
                        {
                            luxury_double_room.add_room();
                        }
                        
                        else if(choice==2)
                        {
                            deluxe_double_room.add_room();
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.add_room();
                        }
                        else if(choice==4)
                        {
                            deluxe_single_room.add_room();
                        }
                        else 
                        {
                            throw new Input_Exception("Bad input : Closing Application");
                        }
                    }
                    else if(choice==4)
                    {
                        room_type();
                        choice  = input.nextInt(); 
                        if(choice==1) 
                        {
                            luxury_double_room.order_fod();
                        }
                        
                        else if(choice==2)
                        {
                            deluxe_double_room.order_fod();
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.order_fod();
                        }
                        else if(choice==4)
                        {
                            deluxe_single_room.order_fod();
                        }
                        else 
                        {
                            throw new Input_Exception("Bad input : Closing Application");
                        }
                    }
                    else if(choice ==5)
                    {
                        room_type();
                        choice  = input.nextInt(); 
                        if(choice==1) 
                        {
                            luxury_double_room.check_out();
                        }
                        
                        else if(choice==2)
                        {
                            deluxe_double_room.check_out();
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.check_out();
                        }
                        else if(choice==4)
                        {
                            deluxe_single_room.check_out();
                        }
                        else 
                        {
                            throw new Input_Exception("Bad input : Closing Application");
                        }
                        
                    }
                    else if(choice ==6) 
                    {
                        System.out.println("Exiting Customer View");
                        break;
                    }
                    else
                    {
                        throw new Input_Exception("Bad Input: Closing Application");
                    }
                }
            }
            else if(choice==2)
            {
                System.out.println("Welcome to the Receptionist View");
                reception_view();
                choice = input.nextInt();
                if(choice==1)
                {
                    room_type();
                    choice  = input.nextInt();
                    if(choice==1) 
                        {
                            luxury_double_room.add_room();
                        }    
                        else if(choice==2)
                        {
                            deluxe_double_room.add_room();
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.add_room();
                        }
                        else if(choice==4)
                    {
                            deluxe_single_room.add_room();
                    }
                    else 
                    {
                        throw new Input_Exception("Bad input : Closing Application");
                    }
                }
                else if(choice==2)
                {
                    room_type();
                    choice  = input.nextInt();
                    System.out.println("Please Enter the Name to search ");
                    String name = input.next();
                    if(choice==1) 
                        {
                            luxury_double_room.search(name);
                        }    
                        else if(choice==2)
                        {
                            deluxe_double_room.search(name);
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.search(name);
                        }
                        else if(choice==4)
                    {
                            deluxe_single_room.search(name);
                    }
                    else 
                    {
                        throw new Input_Exception("Bad input : Closing Application");
                    }
                }
                else if(choice==3)
                {
                    room_type();
                    choice  = input.nextInt();
                    if(choice==1) 
                        {
                            luxury_double_room.upgrade_detials();
                        }    
                        else if(choice==2)
                        {
                            deluxe_double_room.upgrade_detials();
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.upgrade_detials();
                        }
                        else if(choice==4)
                    {
                            deluxe_single_room.upgrade_detials();
                    }
                    else 
                    {
                        throw new Input_Exception("Bad input : Closing Application");
                    }
                    
                }
                else if(choice==5)
                {
                    
                        room_type();
                        choice  = input.nextInt(); 
                        if(choice==1) 
                        {
                            luxury_double_room.order_fod();
                        }
                        
                        else if(choice==2)
                        {
                            deluxe_double_room.order_fod();
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.order_fod();
                        }
                        else if(choice==4)
                        {
                            deluxe_single_room.order_fod();
                        }
                        else 
                        {
                            throw new Input_Exception("Bad input : Closing Application");
                        }
                }
                else if(choice==6)
                {
                        room_type();
                        choice  = input.nextInt(); 
                        if(choice==1) 
                        {
                            luxury_double_room.check_out();
                        }
                        
                        else if(choice==2)
                        {
                            deluxe_double_room.check_out();
                        }
                        else if(choice==3)
                        {
                            luxury_single_room.check_out();
                        }
                        else if(choice==4)
                        {
                            deluxe_single_room.check_out();
                        }
                        else 
                        {
                            throw new Input_Exception("Bad input : Closing Application");
                        }
                        
                }
                    
            }
            else if(choice==3)
            {
                System.out.println("Closing Application");
                return;
            }
            else
            {
                System.out.println("You have entered the either of the above choices");
                throw new Input_Exception("Bad Input : Ending Application ");
            }
        }
    }

    private static void Db_Connection() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection("jdbc:sqlite:data.db");
        Statement statement;
        statement = connection.createStatement();
        statement.execute("Select * from sample");
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next())
        {
            System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
        }
        statement.close();
        connection.close();
    }

    private static void customer_view()
    {
        System.out.println("====================");
        System.out.println("1. Display Room Detials");
        System.out.println("2. Display Room Availability");
        System.out.println("3. Book");
        System.out.println("4. Order Food");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
    }

    private static void room_type() 
    {
        System.out.println("1. Luxury Double Room");
        System.out.println("2. Deluxe Double Room");
        System.out.println("3. Luxury Single Room");
        System.out.println("4. Deluxe Single Room");
    }
    static void  reception_view()
    {
        System.out.println("1. Storing Customer Details");
        System.out.println("2. Searching Customer Details");
        System.out.println("3. Upgrade and delete details");
        System.out.println("4. Booking or upgrading room");
        System.out.println("5. Ordering Food for Particular Room");
        System.out.println("6. Check out for customer and showing bill");
    }
    
    
}
