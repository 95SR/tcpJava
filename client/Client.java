package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    //fields
    public static InetAddress ia;

    public static void clientStart(int port){
        try  {

            ia = InetAddress.getLocalHost();
            Socket socket = new Socket(ia, port);
            
        }catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
