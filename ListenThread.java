

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ListenThread extends Thread{
    //fields
    private BufferedReader br;
    

    //constructor
    public ListenThread(Socket socket){
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    //run
    @Override
    public void run() {
        try {
            String messageFromServer;

            while(true){
                messageFromServer= br.readLine();
                if(messageFromServer.equals(null)){
                    
                   // br.close();
                    
                    break;
                }

                System.out.println(messageFromServer);

                
               

            }

            
        } catch (Exception e) {
            
            System.out.println("Server die");
            System.exit(0);
            
        }


    
        
    }

        
    
}

