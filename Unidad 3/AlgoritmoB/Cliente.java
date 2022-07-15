//package Algoritmo;

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

    public static void Imprimir(Proceso p1, Proceso s, Proceso p2, Proceso p3, String info) {
        System.out.println("ESTADO ACTUAL - " + info);
        p1.Imprimir();
        s.Imprimir();
        p2.Imprimir();
        p3.Imprimir();
        System.out.println("------------------------------------------");
    }

    public static void Aumento(Proceso p1, Proceso s, Proceso p2, Proceso p3, int tt) {
        p1.Aumento(tt);
        s.Aumento(tt);
        p2.Aumento(tt);
        p3.Aumento(tt);
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Client Iniciado.");
        try (
                Socket socket = new Socket(HOST, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner in = new Scanner(socket.getInputStream());
                Scanner sc = new Scanner(System.in);) {
            int tt = 4;            
            Proceso p1 = new Proceso("C1", 51);
            Proceso p2 = new Proceso("C2", 56);
            Proceso p3 = new Proceso("C3", 49);            
            out.println(1);
            String input = in.nextLine();
            Proceso s = new Proceso("S", Integer.parseInt(input));
            int t0 = s.getTiempo();
            // comienzo
            Imprimir(p1, s, p2, p3,"Comienzo");
            //primer aumento
            Aumento(p1, s, p2, p3, tt);
            // imprimir primer aumento
            Imprimir(p1, s, p2, p3,"Primera suma de tiempo");
            
            // Calculos
            int D1 = p1.getTiempo() - t0;
            int D2 = p2.getTiempo() - t0;
            int D3 = p3.getTiempo() - t0;
            
            // Calculos de D
            System.out.println("CALCULOS");
            System.out.println("T0: "+t0);
            System.out.println("D1: "+ D1);
            System.out.println("D2: "+ D2);
            System.out.println("D3: "+ D3);
            System.out.println("------------------------------------------");
            // Segundo Aumento
            Aumento(p1, s, p2, p3, tt);
            // imprimir segundo aumento
            Imprimir(p1, s, p2, p3,"Segunda suma de tiempo");
            
            // Calculos de D'
            
            int tli = s.getTiempo();
            int D1d = D1 - ((tli-t0)/2);
            int D2d = D2 - ((tli-t0)/2);
            int D3d = D3 - ((tli-t0)/2);
            int d = (D1d + D2d + D3d +0)/4;
            
            // Calculos de D
            System.out.println("CALCULOS");
            System.out.println("TLI: "+tli);
            System.out.println("T0: "+t0);
            System.out.println("D1': "+ D1d);
            System.out.println("D2': "+ D2d);
            System.out.println("D3': "+ D3d);
            
            System.out.println("------------------------------------------");
            System.out.println("D: "+ d);
            
            // Suma o resta dependiendo de D
            s.setTiempo(s.getTiempo()+(d));            
            // Imprimir
            Imprimir(p1, s, p2, p3, "Suma o resta dependiendo de el calculo D");         
            
            // Calculos A            
            int A1 = d - D1d ;
            int A2 = d - D2d ;
            int A3 = d - D3d ;            
            // Aumento 3            
            Aumento(p1, s, p2, p3, tt);            
            // Imprimir 3ra vez            
            Imprimir(p1, s, p2, p3, "Tercera Suma de tiempo");           
            
            // Imprimir Calculos de A            
            System.out.println("CALCULOS");
            System.out.println("A1': "+ A1);
            System.out.println("A2': "+ A2);
            System.out.println("A3': "+ A3);            
            System.out.println("------------------------------------------");
            // Operaciones dependiendo de A
            
            p1.setTiempo(p1.getTiempo()+(A1));
            p2.setTiempo(p2.getTiempo()+(A2));
            p3.setTiempo(p3.getTiempo()+(A3));            
            
            // imprimir
            
            Imprimir(p1, s, p2, p3, "Resultado Final Sincronizado");
            
        }
    }

}
