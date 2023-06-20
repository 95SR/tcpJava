package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //port를 가지고 서버 소켓 생성
    //클라인트 소켓 받기
    //소켓을 쓰레드로 던지기
    

    public static void startServer(Integer port){
       try (ServerSocket sSocket = new ServerSocket(port)){
        while(true){
            Socket cSocket = sSocket.accept();

            ServerThread sManager = new ServerThread(cSocket);
            sManager.start();

        }
       
        
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    }


    public static void stopServer(){

    }
}
