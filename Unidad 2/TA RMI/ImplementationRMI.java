
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ImplementationRMI extends UnicastRemoteObject implements InterfazRMI{
    public ImplementationRMI() throws RemoteException{
        super();
    }

    public String saludar(String nombre) throws RemoteException{
        return "Bienvenido al sistema! "+nombre+" un gusto";
    }

    @Override
    public boolean comprobarSaldo(float monto, float saldo) throws RemoteException {
        if (monto<=saldo) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean Deposito(float monto) throws RemoteException {
        if (monto > 0) {
            return true;
        }else{
            return false;
        }
    }
}
