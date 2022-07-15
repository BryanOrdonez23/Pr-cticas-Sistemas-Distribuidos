package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author UserPc
 */
public class Cliente {

    private static int port = 5000;
    private static String host = "127.0.0.1";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Socket socket = new Socket();
        System.out.println("Iniciando el socket para comunicarnos");
        
        for (int i = 0; i < 10; i++) {
            Socket socket = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Mi primera vez");
        }
        //socket.close();
    }

}
