import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Repertoire {
    final static String localHost = "127.0.0.1";
    Fichier getFile(String Machine, String keyWord){
        int port = 0;
        if (Machine.equals("Machine1")){
            port= 2029;
        }else if(Machine.equals("Machine2")){
            port = 2030;
        }
        try{
            Registry registry= LocateRegistry.getRegistry(localHost,port);
            Methods methods =(Methods) registry.lookup(Machine);
           return methods.getFile(keyWord);
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
