

import java.util.ArrayList;

public class SocketManager {
    private static ArrayList<ServerThread> clientSocket = new ArrayList<ServerThread>();

    // public SocketManager(){

    // }

    public static void addSocket( ServerThread thread){
        System.out.println(clientSocket + "before");
        clientSocket.add(thread);
        System.out.println(clientSocket + "after");

    }

    public static void removeSocket(ServerThread thread){
        
        clientSocket.remove(thread);
        sendMessage(thread, thread.userName + " left the chat", true);
        

    }

    public static void sendMessage(ServerThread thread, String message){
        for (ServerThread client : clientSocket) {
            if(thread != client){
                client.writer.println(thread.userName + ": " + message);
            }   
        }
    }

    public static void sendMessage(ServerThread thread, String message, boolean server){
        for (ServerThread client : clientSocket) {
            if(thread != client){
                client.writer.println( "SERVER: " + message);
            }   
        }
    }

    public static void sendToAll(String message){
        for (ServerThread client : clientSocket) {
            
                client.writer.println( "SERVER: " + message);
             
        }
    }


    

    
    
}
