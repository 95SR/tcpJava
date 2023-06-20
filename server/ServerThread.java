package server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerThread extends Thread {
    //소켓을 관리하는 클래스
    //추가,제거,메시지 보내기

    //define fields
    public InputStream instream;
    public OutputStream outstream;
    public BufferedReader br;
    public PrintWriter writer;
    public String userName;
    


    //create constructor
    public ServerThread(Socket socket){
        try {
            instream = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(instream));

            outstream = socket.getOutputStream();
            writer = new PrintWriter(outstream, true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //run
    @Override
    public void run() {
        

        try {
            this.userName = br.readLine(); 
        SocketManager sm = new SocketManager();
        sm.addSocket(this);
        String fromClient;
        
            do {

                fromClient= br.readLine();
                
                sm.sendMessage(this, fromClient);
                
            } while (!fromClient.equals("bye"));
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
