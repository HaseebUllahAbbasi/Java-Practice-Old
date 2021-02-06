package console_1;

import static console_1.Luxury_Double_Room.charge_per_day;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Deluxe_Double_Room implements Room 
{

    Scanner input = new Scanner(System.in);
    static int double_beds = 1;
    static boolean Ac = true;
    static boolean breakfast_fee = true;
    static int  charge_per_day = 3500;
    Customer[] list = new Customer[10];
    ArrayList<Integer> room_list = new ArrayList<Integer>();
    int Limit = 10;
    int booked = 0;

    public Deluxe_Double_Room() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection("jdbc:sqlite:base.db");
        Statement statement;
        statement = connection.createStatement();
        statement.execute("Select * from [del_double]");
        ResultSet resultSet = statement.getResultSet();
        int i=0;
        while(resultSet.next())
        {
            list[i] = new Customer();
            list[i].bill = resultSet.getInt(4);
            list[i].name = resultSet.getString(2);
            list[i].contact = resultSet.getString(3);
            list[i].room_no = resultSet.getInt(1);
            if(resultSet.getString(2)!=null)
            {
                booked++;
                room_list.add(resultSet.getInt(1));
            }
            i++;
        }
        statement.close();
        connection.close();
    }
    
    public void search(String name)
    {
        for(Customer cust : list)
        {
            if(cust.name!=null)
            {
                if(cust.name.equals(name))
                {
                    System.out.println("found");
                    System.out.println(cust);
                }
            }
        }
    }
    
    public void upgrade_detials() throws SQLException
    {
        if(booked>0)
        {
            System.out.println("Enter room");
            int index = input.nextInt();
            if(room_list.contains(new Integer(index)))
            {
                
                System.out.println("Enter name");
                String name = input.next();
                
                System.out.println("Enter contact");
                String contact = input.next();

                list[index].name = name;
                list[index].contact = contact;
                list[index].room_no = (index);
                list[index].bill = charge_per_day;
                
                booked++;
                Connection connection;
                connection = DriverManager.getConnection("jdbc:sqlite:base.db");
                Statement statement;
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE [lux_double] SET name='"+name+"', contact= '"+contact+"',bill="+charge_per_day+" where number= "+index+" ");
                System.out.println("data has been entered");
            }
            else
            {
             System.out.println("the room is already empty");
            }
        }
        else
        {
            System.out.println("the rooms are already empty");
        }
        
    }
    
    @Override
    public int availability()
    {
        System.out.println("Number of Rooms Available "+(Limit-booked));
        return Limit-booked;
    }

    @Override
    public void add_room() throws Input_Exception, SQLException
    {

        if(booked<10)
        {
            System.out.println("please enter the room number from ");
            int i=1;
            for(Customer cust :list)
            {
                System.out.print(cust.room_no+" ");
            }
            System.out.println("please Enter");
            int index = input.nextInt();
            if(index>=10)
            {
                throw new Input_Exception("Bad input: Ending Application ");
            }
            else if(room_list.contains(index))
            {
                System.out.println("the entered room is already occupied");
            }
            else
            {
                room_list.add(index);
                System.out.println("Enter name");
                String name = input.next();
                
                System.out.println("Enter contact");
                String contact = input.next();

                list[index].name = name;
                list[index].contact = contact;
                list[index].room_no = (index);
                list[index].bill = charge_per_day;
                
                Connection connection;
                connection = DriverManager.getConnection("jdbc:sqlite:base.db");
                Statement statement;
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE [del_double] SET name='"+name+"', contact= '"+contact+"',bill="+charge_per_day+" where number= "+index+" ");
                System.out.println("data has been entered");
            }
        }
    }
    public void display_detail() throws Exception
    {
        System.out.println("Number of Beds: "+1);
        System.out.println("Ac: Yes");
        System.out.println("Free Breakfast : Yes ");
        System.out.println("Charge per day :"+charge_per_day);
        System.out.println("Continue: Y/N");
        String con = input.next();
        if(con.equals("Y")|| con.equals("y"))
            add_room();
    }
    public void check_out() throws SQLException
    {
        System.out.println("please enter the room number");
        int index = input.nextInt();
        if(room_list.contains(index))
        {
            list[index] = null;
            room_list.remove(new Integer(index));
            
                Connection connection;
                connection = DriverManager.getConnection("jdbc:sqlite:base.db");
                Statement statement;
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE [del_double] SET name="+null+", contact="+null+",bill="+0+" where number= "+index+" ");
                System.out.println("Checkout");
        }
        else
        {
            System.out.println("the room you entered does not exist");
        }
        

    }
    @Override
    public void order_fod() throws SQLException  
    {
        System.out.println("please enter the room number");
        int index = input.nextInt();
        if(room_list.contains(index))
        {
            System.out.println("please enter the food below");
            Food_Menu.Food_Menu();
            System.out.println("please enter ");
            int choice = input.nextInt();
            if(choice==1)
                list[index].bill+=150;
            else if(choice==2)
                list[index].bill+=160;
            else if(choice==3)
                list[index].bill+=170;
            else if(choice==4)
                list[index].bill+=30;

                Connection connection;
                connection = DriverManager.getConnection("jdbc:sqlite:base.db");
                Statement statement;
                statement = connection.createStatement();
                statement.executeUpdate("UPDATE [del_double] SET bill=" +list[index].bill+" where number= "+index+" ");
                System.out.println("data has been entered");
            
            System.out.println("the food is served");
            
        }
        else
        {
            System.out.println("the room is not in list");
        }
    }
}
