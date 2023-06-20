package server;
public class ServerApplication {
    //receive port
    //call method of Server class to start the server

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        

        Server.startServer(port);



    }
}
