import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Methods extends Remote {
    public Fichier getFile(String nameFichier) throws RemoteException;

}
