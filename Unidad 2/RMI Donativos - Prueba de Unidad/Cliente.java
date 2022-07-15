
import java.rmi.Naming;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            InterfazRMI interfaz = (InterfazRMI) Naming.lookup("rmi://localhost/donativos");
            double saldo = 0.0;
            System.out.println(interfaz.saludar("Donador 1"));
            Scanner sn = new Scanner(System.in);
            boolean salir = false;
            int opcion;

            while (!salir) {
                System.out.println("**** SISTEMA DE DONATIVOS ****");
                System.out.println("1. Donar");
                System.out.println("2. Consultar importe total de donaciones.");
                System.out.println("3. Salir");

                try {
                    System.out.println("Escribe una de las opciones");
                    opcion = sn.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingresa el monto a donar: ");
                            Scanner sc2 = new Scanner(new InputStreamReader(System.in));
                            double monto2 = Double.parseDouble(sc2.next());
                            if (interfaz.Donacion(monto2)) {
                                System.out.println("Donativo realizado correctamente...");
                                System.out.println("Monto del donativo por:" + monto2);
                                saldo = (interfaz.CalcularSaldoDonaciones(monto2));
                                
                            } else {
                                System.out.println("No se pudo realizar el donativo...");
                            }
                            System.out.println("---------------------------------------");
                            break;
                        case 2:
                            System.out.println("Tu importe total de donativos es:"+interfaz.VerSaldo());
                            System.out.println("---------------------------------------");
                            break;
                        case 3:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 3");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    sn.next();
                }
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
}
