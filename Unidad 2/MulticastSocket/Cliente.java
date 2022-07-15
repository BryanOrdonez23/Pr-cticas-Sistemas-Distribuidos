

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author UserPc
 */

public class Cliente {
    
    private static int PORT = 5000;
    private static String HOST = "127.0.0.1";
    
     public static void main(String[] args) throws IOException, InterruptedException {
        
        System.out.println("Client started.");
        
        try (
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner s = new Scanner(System.in);
        ) {
            int j = 1;
            while (true) {               
                out.println(String.valueOf(j++));
                System.out.println("Sent: Mensaje enviado:"+(j-1));
                Thread.sleep(2000);
            }
        }
    }
}
