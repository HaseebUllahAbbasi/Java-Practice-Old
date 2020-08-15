package socket.multiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echo extends Thread
{
    private Socket socket;
    Echo(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

            while (true)
            {
                String echoString = input.readLine();
                if(echoString.equals("exit"))
                {
                    break;
                }
                System.out.println("Echo from the server "+echoString);
            }

        }
        catch (Exception e)
        {

        }
        finally {
            try {
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
