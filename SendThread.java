

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class SendThread extends Thread{
    //fields
    private PrintWriter pr;
   

    //constructor
    public SendThread(Socket socket){
        try {
            pr = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //run
    @Override
    public void run() {
        try {
            String messageToServer;
            Scanner scanner;
            do {
                scanner = new Scanner(System.in);
                messageToServer = scanner.nextLine();
                pr.println(messageToServer);


            } while (!messageToServer.equals("bye"));

            pr.close();

        
        } catch (Exception e) {
            // TODO: handle exception
            
        }
    }

   
}
