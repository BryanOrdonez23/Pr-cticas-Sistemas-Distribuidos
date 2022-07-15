

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author UserPc
 */
public class Cliente {

    private static int PORT = 5000;
    private static String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Client Iniciado.");
        try (
                Socket socket = new Socket(HOST, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner in = new Scanner(socket.getInputStream());
                Scanner s = new Scanner(System.in);) {
            long t0;
            long tcs;
            long t1;
            long tc;
             DateFormat formato = new SimpleDateFormat(":SSS");
            // asignación de un tiempo inicial desde el cliente.
            t0 = System.currentTimeMillis();
            // Envio al servidor del T0
            out.println(t0);
            String input = in.nextLine();
            // Asignación de un tiempo de llegada del mensaje del servidor.
            t1 = System.currentTimeMillis();
            long aux = Long.parseLong(input);
            tc = ( aux + ((t1 - t0) / 2));
            // formato para el tiempo
            
            System.out.println("Tiempo inicial desde el cliente (t0):" + formato.format(new Date(t0)));
            System.out.println("Tiempo devuelto por el servidor (tcs):" + formato.format(new Date(Long.parseLong(input))));
            System.out.println("Tiempo de llegada del mensaje al cliente (t1):" + formato.format(new Date(t1)));
            System.out.println("Calculo:");
            System.out.println("                    Tc = Tsc + (T1-T0)/2");
            System.out.println("Tiempo calculado para la sincronización:" + formato.format(new Date(tc)));
            
            if (t1 > tc) {
                System.out.println("Se realiza una Retención");
            } else {
                System.out.println("Se realiza una Actualización");
            }
        }
    }
}
