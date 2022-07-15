
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author UserPc
 */
public class Servidor {
    
    private static int PORT = 5000;
     public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        
        System.out.println("Server started...");
        System.out.println("Wating for clients...");
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread() {
                public void run() {
                    try (
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        Scanner in = new Scanner(clientSocket.getInputStream());
                    ) {
                        while (in.hasNextLine()) {
                            String input = in.nextLine();
                            System.out.println("Recivied: Mensaje recivido desde el cliente: " + input);
                        }
                    } catch (IOException e) { }
                }
            };
            t.start();
        }
    }   
}
