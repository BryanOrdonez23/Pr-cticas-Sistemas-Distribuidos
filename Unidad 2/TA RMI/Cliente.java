
import java.rmi.Naming;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            InterfazRMI interfaz = (InterfazRMI) Naming.lookup("rmi://localhost/banco");
            float saldo = 1000;
            System.out.println(interfaz.saludar("Usuario1"));
            Scanner sn = new Scanner(System.in);
            boolean salir = false;
            int opcion;

            while (!salir) {
                System.out.println("**** SISTEMA BANCARIO ****");
                System.out.println("1. Retirar");
                System.out.println("2. Depositar");
                System.out.println("3. Consultar Saldo");
                System.out.println("4. Salir");

                try {

                    System.out.println("Escribe una de las opciones");
                    opcion = sn.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingresa el monto a retirar: ");
                            Scanner sc1 = new Scanner(new InputStreamReader(System.in));
                            float monto = Float.valueOf(sc1.next());
                            if (interfaz.comprobarSaldo(monto, saldo)) {
                                System.out.println("Transacción realizada correctamente");
                                saldo = saldo - monto;
                                System.out.println("Tu saldo actual es de :" + saldo);
                            } else {
                                System.out.println("No se pudo realizar la transacción");
                            }
                            System.out.println("---------------------------------------");
                            break;
                        case 2:
                            //
                            System.out.println("Ingresa el monto a depositar: ");
                            Scanner sc2 = new Scanner(new InputStreamReader(System.in));
                            float monto2 = Float.valueOf(sc2.next());
                            if (interfaz.Deposito(monto2)) {
                                System.out.println("Transacción realizada correctamente");
                                saldo = saldo + monto2;
                                System.out.println("Tu saldo actual es de :" + saldo);
                            } else {
                                System.out.println("No se pudo realizar el deposito");
                            }
                            System.out.println("---------------------------------------");
                            break;
                        case 3:
                            System.out.println("Tu saldo actual es de:"+saldo);
                            System.out.println("---------------------------------------");
                            break;
                        case 4:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 4");
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
