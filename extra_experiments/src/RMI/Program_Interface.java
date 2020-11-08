package RMI;

import java.rmi.Remote;
import java.util.ArrayList;

public interface Program_Interface extends Remote
{


    public String listAllSeatsFromServer() throws Exception;
    public String reserverSeat(String name, String class_name, int seatNumber) throws Exception;
    public ArrayList<String> showAllPassangers() throws Exception;

}

