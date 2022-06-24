
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ImplementationRMI extends UnicastRemoteObject implements InterfazRMI{
    private double saldo = 0.0; //10
    
    public ImplementationRMI() throws RemoteException{
        super();
    }

    public String saludar(String nombre) throws RemoteException{
        return "Bienvenido al sistema! "+nombre+" un gusto \n";
    }

    @Override
    public boolean Donacion(double monto) throws RemoteException {
        if (monto > 0) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double CalcularSaldoDonaciones(double monto) throws RemoteException {
       saldo = saldo + monto; // saldo = 10 / 11
       return  monto;
    }

    @Override
    public double VerSaldo() throws RemoteException {
        return saldo;
    }
}
