

import java.util.*;

public class AlgoritmoLa {

    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar el numero de procesos: ");
        int np = sc.nextInt();
        //definimos el numero de procesos y eventos
        L_Process p[] = new L_Process[np];
        L_Event e[][] = new L_Event[np][];
        HashMap<String, Integer> hm = new HashMap<>();
        
        // Recoleccion de datos
        for (int ii = 0; ii < np; ii++) {
            p[ii] = new L_Process();
            p[ii].reloj = 0;
            System.out.println("Ingresar el numero de eventos de P" + (ii + 1) + " :");
            int ne = sc.nextInt();
            e[ii] = new L_Event[ne];
            for (int j = 0; j < ne; j++) {
                e[ii][j] = new L_Event();
                System.out.println("Ingresar el nombre del evento "+(j+1));
                e[ii][j].nombre = sc.next();
                System.out.println("Selecccione el estado(  enviar(e) , recibir(r) o inactivo (i)) ");
                e[ii][j].estado = sc.next();
                if (e[ii][j].estado.equals("r")) {
                    System.out.println("Ingrese el nombre del nodo con la relación. ");
                    e[ii][j].envioEvento = sc.next();
                }
            }
        }
        int i = 0;
        boolean signal1 = false, signal2 = false;
        
        // Configurando los estados de los nodos.
        while (i < np) {
            for (int j = 0; j < e[i].length; j++) {
                if (e[i][j].m_tiempo == 0) {
                    if (e[i][j].estado.equals("i")) {
                        p[i].reloj += 1;
                        e[i][j].m_tiempo = p[i].reloj;
                        hm.put(e[i][j].nombre, e[i][j].m_tiempo);
                    } else if (e[i][j].estado.equals("e")) {
                        p[i].reloj += 1;
                        e[i][j].m_tiempo = p[i].reloj;
                        e[i][j].msg = p[i].reloj;
                        hm.put(e[i][j].nombre, e[i][j].m_tiempo);
                    } else {
                        String se = e[i][j].envioEvento;
                        if (hm.containsKey(se)) {
                            p[i].reloj = Math.max(p[i].reloj + 1, hm.get(se) + 1);
                            e[i][j].m_tiempo = p[i].reloj;
                            hm.put(e[i][j].nombre, e[i][j].m_tiempo);
                        } else {
                            break;
                        }
                    }
                }
            }
            for (int j = 0; j < e[i].length; j++) {
                if (e[i][j].m_tiempo == 0) {
                    signal1 = true;
                }
            }
            if (signal1 == false) {
                p[i].eventosfin = true;
            }
            signal1 = false;
            for (int j = 0; j < np; j++) {
                if (p[j].eventosfin == false) {
                    signal2 = true;
                }
            }
            if (signal2 == false) {
                break;
            }
            signal2 = false;
            if (i == np - 1) {
                i = 0;
            } else {
                i += 1;
            }
        }
        // Imprimiendo los eventos
        System.out.println("-----------------------------------------------------------");
        System.out.println(" Resultados del Algoritmo de Lamport ");
        for (int j = 0; j < np; j++) {
            System.out.print("P" + (j + 1) + ": ");
            for (int k = 0; k < e[j].length; k++) {
                System.out.print(e[j][k].nombre + "[" + e[j][k].m_tiempo +"]");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------");
    }
}


