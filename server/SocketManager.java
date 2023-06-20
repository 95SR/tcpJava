package server;

import java.util.ArrayList;

public class SocketManager {
    private ArrayList<ServerThread> clientSocket;

    public SocketManager(){

    }

    public  void addSocket( ServerThread thread){
        clientSocket.add(thread);

    }

    public  void removeSocket(ServerThread thread){

    }

    public void sendMessage(ServerThread thread, String message){
        for (ServerThread client : clientSocket) {
            if(thread != client){
                client.writer.println(thread.userName + ": " + message);
            }
            
        }
        

    }

    
    
}
