import java.io.File;
import java.rmi.*;
import java.rmi.server.*;

public class FileServer extends UnicastRemoteObject implements Methods {
    public FileServer() throws RemoteException {
    }

    @Override
    public Fichier getFile(String nameFichier)throws RemoteException {
        String extension = ".txt";
        File file = new File("Fichier//"+nameFichier+extension);
        String path= file.getAbsolutePath();
        String content = "empty";

        return new Fichier(nameFichier,content,path,extension);
    }
}

