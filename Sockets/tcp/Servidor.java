package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static int port = 5000;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Socket socket = new Socket();
        server = new ServerSocket(port);
        while (true) {
            System.out.println("Waiting for the socket");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            ois.close();
            socket.close();
            System.out.println("Fisished!");            
        }
        //server.close();
    }

}
