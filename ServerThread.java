
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

    // define fields
    public InputStream instream;
    public OutputStream outstream;
    public BufferedReader br;
    public PrintWriter writer;
    public String userName;
    public Socket socket;

    // create constructor
    public ServerThread(Socket csocket) {
        try {
            socket = csocket;
            instream = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(instream));

            outstream = socket.getOutputStream();
            writer = new PrintWriter(outstream, true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // run
    @Override
    public void run() {

        try {
            this.userName = br.readLine();
            SocketManager.sendMessage(this, this.userName + " has entered the chat room", true);

            // SocketManager sm = new SocketManager();

            SocketManager.addSocket(this);
            System.out.println("added");
            String fromClient;


            while(true){
                fromClient = br.readLine();
                if(fromClient.equals("bye")){
                    SocketManager.removeSocket(this);
                    break;

                }

                SocketManager.sendMessage(this, fromClient);
            }

           

            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
