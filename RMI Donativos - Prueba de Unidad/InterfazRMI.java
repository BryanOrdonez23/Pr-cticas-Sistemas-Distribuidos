
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazRMI extends Remote{
    public String saludar(String msj)throws RemoteException;
    public boolean Donacion(double monto) throws RemoteException;
    public double CalcularSaldoDonaciones (double monto) throws RemoteException;
    public double VerSaldo () throws RemoteException;
}
