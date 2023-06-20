package client;

public class ClientApplication {
    
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        Client.clientStart(port);
    }
}
