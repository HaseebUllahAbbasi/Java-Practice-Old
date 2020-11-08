package RMI;

import java.rmi.registry.Registry;

import java.rmi.server.UnicastRemoteObject;

import java.util.ArrayList;

import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;

public class Server extends UnicastRemoteObject implements Program_Interface
{
    protected Server() throws RemoteException
    {
        super();
    }

    //Maintain Booking status of 30 seats
    static Boolean bookedStatus[]=new Boolean[30];
    //Store names of passangers
    static ArrayList<String> passangers=new ArrayList<String>();
    public static void main(String[] args)
    {
        //Create registry and assign port to which clients can communicate
        try
        {
            Registry reg=LocateRegistry.createRegistry(9999);
            reg.rebind("Server_Connection", new Server());
            //All seats are not booked at first
            for(int i=0;i<30;i++)
            {
                    bookedStatus[i]=false;
            }
            }
        catch (Exception e)
        {
                e.printStackTrace();
        }
    }
    //Serve request1: List all available seats
    public String listAllSeatsFromServer()
    {
        int businessHighPricedTickets=0, businessLowPricedTickets=0;

        int economyLowPricedTickets=0, economyMediumPricedTickets=0,economyHighPricedTickets=0;

        String businessClassSeatNumbers="",economyClassSeatNumbers="";
        for(int i=0;i<30;i++)
        {
            if(bookedStatus[i]==false)
            {
            //For Business class
                if((i)<5)
                {
                    if(i<3)
                    {
                        businessLowPricedTickets++;
                    }
                    else
                        {
                        businessHighPricedTickets++;

                    }
                    businessClassSeatNumbers=businessClassSeatNumbers+"  "+(i+1);
                }
                //For economy class
                else if(i>=5 && i<=29)
                {
                    if(i>=5 && i<=14)
                    {
                        economyLowPricedTickets++;
                    }
                    else if(i>=15 && i<=24)
                    {
                        economyMediumPricedTickets++;
                    }
                    else
                        {
                        economyHighPricedTickets++;
                    }
                    economyClassSeatNumbers=economyClassSeatNumbers+"  "+(i+1);
                }
            }
        }
        String businessClassStr="Business Class:\n"+businessLowPricedTickets+" @ $500 each\n"+businessHighPricedTickets+" @ $800 each\nSeat Numbers: "+businessClassSeatNumbers;
        String economyClassStr="\n\nEconomy Class:\n"+economyLowPricedTickets+" @ $200 each\n"+economyMediumPricedTickets+" @ $300 each\n"+economyHighPricedTickets+" @ $450 each\nSeat Numbers: "+economyClassSeatNumbers;
        return businessClassStr+economyClassStr;
    }
    //Server Request2: Reserver particular seat for particular passanger in particular class
    @Override
    public String reserverSeat(String name, String class_name, int seatNumber) throws Exception
    {
        String message="";
        if(class_name.equalsIgnoreCase("Business"))
        {
            if(seatNumber>=1 && seatNumber<=5)
            {
                if(bookedStatus[seatNumber-1]==false)
                {
                    message="Secessfully Reserved Seat:"+seatNumber+" For Passanger: "+name;
                    bookedStatus[seatNumber-1]=true;
                    passangers.add(name);
                }
                else
                    {
                    message="Failed to reserve: Seat Not Available!";
                }
            }
            else
                {
                message="Failed to reserve: Invalid Seat Number";
            }
        }
        else if(class_name.equalsIgnoreCase("Economy"))
        {
            if(seatNumber>=6 && seatNumber<=30)
            {
                if(bookedStatus[seatNumber-1]==false)
                {
                    message="Secessfully Reserved Seat:"+seatNumber+" For Passanger: "+name;
                    bookedStatus[seatNumber-1]=true;
                    passangers.add(name);
                }
                else
                    {
                    message="Failed to reserve: Seat Not Available!";
                }
            }
            else
                {
                message="Failed to reserve: Invalid Seat Number";
            }
        }
        else
            {
            message="\nIncorrect Class name provided: give Economy of Business";
        }
        return message;
    }
    @Override
    public ArrayList<String> showAllPassangers() throws Exception
    {
        return passangers;
    }
}

