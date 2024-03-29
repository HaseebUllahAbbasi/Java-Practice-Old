package socket.multiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    /*

     *
     * This code is provided to get the have multiple clients but error that one is connected and another created then
     new one waits until first one complete the first statement
     */
    /*

     */
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                String echoString = input.readLine();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

                if(echoString.equals("exit")) {
                    break;
                }
                output.println("Echo from server: " + echoString);
            }


        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }


}