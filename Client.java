

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    

    public static void clientStart(int port) {

        try {

            InetAddress ia = InetAddress.getLocalHost();
            Socket socket = new Socket(ia, port);

            
                System.out.println("Enter username: ");
                ListenThread listenThread = new ListenThread(socket);
                listenThread.start();
                SendThread sendThread = new SendThread(socket);
                sendThread.start();
                
            

        } catch (UnknownHostException e) {
            
            e.printStackTrace();
            System.out.println("unknow host");

        } catch (IOException e) {
            
            System.out.println("Server is not active currently");
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        Client.clientStart(port);

    }
}
