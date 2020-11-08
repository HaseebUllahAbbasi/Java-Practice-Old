package RMI;

import java.util.ArrayList;
import java.util.Scanner;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Client
{
    static Program_Interface p_interface=null;
    public static void main(String[] args)
    {
        //Build connection with server at port 9999, We can provide IP of server if Server.java is running on other machine
        try
        {
            Registry reg=LocateRegistry.getRegistry("localhost",9999);
            p_interface=(Program_Interface)reg.lookup("Server_Connection");
        }
        catch (Exception e)
        {
            System.out.println("Connection failed...");
        }
        System.out.println("_________________________________________");
        System.out.println("Welcome to RMI Client Server Architecture");
        System.out.println("_________________________________________");
        System.out.println();
        System.out.println("Press 1 to Book seat!");
        System.out.println("Press 2 to List All seats!");
        System.out.println("Press 3 to list all passangers!");
        System.out.println("Press E to Exit");
        Scanner input=new Scanner(System.in);
        String choice=input.next();
        while(choice.equalsIgnoreCase("E")==false)
        {
            switch(choice) {
                case "1":
                    bookSeat();
                    break;

                case "2":
                    listAllSeats();
                    break;

                case "3":
                    listPassangers();
                    break;

                default:
                    System.out.println("Invalid Choice...");
                    break;
            }
            System.out.println("\nPress 1 to Book seat!");
            System.out.println("Press 2 to List All seats!");
            System.out.println("Press 3 to list all passangers!");
            System.out.println("Press E to Exit");
            choice=input.next();
        }
    }

    //Request1: List all available seats, this list is maintained by the server
    public static void listAllSeats()
    {
        try {
            System.out.println();
            System.out.println(p_interface.listAllSeatsFromServer());
            System.out.println();

        } catch (Exception e) {
            System.out.println("Connection to server Failed...");
        }
    }
    //Request2: Reserver a particular seat from particular class for a particular Passanger

    public static void bookSeat()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name=sc.next();
        System.out.println("Enter Class: Economy/Business!");
        String class_name=sc.next();

        System.out.println("Enter Seat Number: ");
        int seatNumber=sc.nextInt();

        try {
            //Takes arguments and shows message after checking seat number, class, availability etc at server side
            System.out.println();
            System.out.println(p_interface.reserverSeat(name, class_name, seatNumber));
            System.out.println();

        } catch (Exception e) {
            System.out.println("Connection to server Failed...");

        }
    }

    //Request3: Lists all passangers who have booked today

    public static void listPassangers()
    {
        System.out.println("\nList Of Passangers traveling today....\n");
        try
        {
            //List of passangers returned by Server
            ArrayList<String> passangers=p_interface.showAllPassangers();
            for(int i=0;i<passangers.size();i++) {
                System.out.println((i+1)+". "+passangers.get(i));
            }
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("Connection to server Failed...");
        }
    }
}
