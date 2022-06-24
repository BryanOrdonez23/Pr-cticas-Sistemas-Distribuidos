
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazRMI extends Remote{
    public String saludar(String msj)throws RemoteException;
    public boolean comprobarSaldo(float monto, float saldo) throws RemoteException;
    public boolean Deposito(float monto) throws RemoteException;
}
