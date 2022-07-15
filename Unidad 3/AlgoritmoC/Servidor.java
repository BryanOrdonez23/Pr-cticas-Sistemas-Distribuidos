

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                        Scanner in = new Scanner(clientSocket.getInputStream());) {
                        String input = in.nextLine();
                        long tcs;
                        // asignación de un tiempo del servidor y envio al cliente como respuesta.
                        tcs = System.currentTimeMillis();
                        DateFormat formato = new SimpleDateFormat(":SSS");
                        out.println(tcs);
                        System.out.println("Tiempo devuelto por el servidor: " + formato.format(new Date(tcs)));
                    } catch (IOException e) {
                    }
                }
            };
            t.start();
        }
    }
}
