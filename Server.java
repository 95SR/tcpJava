
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void startServer(Integer port) {
        // port를 가지고 서버 소켓 생성
        // 클라인트 소켓 받기
        // 소켓을 쓰레드로 던지기
        try (ServerSocket sSocket = new ServerSocket(port)) {
            serverCmd cmd = new serverCmd(sSocket);
            cmd.start();
            while (true) {

                System.out.println("Accepting client..");
                Socket cSocket = sSocket.accept();
                System.out.println("New client entered");

                ServerThread sManager = new ServerThread(cSocket);
                sManager.start();

            }

        } catch (IOException e) {

            System.exit(0);
        }

    }

    static class serverCmd extends Thread {
        // fields
        private ServerSocket sSocket;

        public serverCmd(ServerSocket socket) {
            sSocket = socket;
        }

        @Override
        public void run() {
            System.out.println("start the cmd thread");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("turn off")) {
                System.out.println("preparing to shut down");
                SocketManager.sendToAll("Server is going to shutdown in 10s");
                try {
                    sSocket.close();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Can not close the server");
                }

            }
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        Server.startServer(port);

    }
}
