package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)  {
        try (Socket socket = new Socket("localhost",5000))
        {
            BufferedReader echo = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter StringEcho = new PrintWriter(socket.getOutputStream(),true);

            Scanner input = new Scanner(System.in);
            String echoString;
            String response;
            do
            {
                System.out.println("Enter the String");
                echoString = input.nextLine();
                StringEcho.println(echoString);
                if(!echoString.equals("exit"))
                {
                    response = echo.readLine();
                    System.out.println(response);
                }
            }
            while (!echoString.equals("exit"));
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }
}
