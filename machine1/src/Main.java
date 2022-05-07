import java.rmi.*;
import java.rmi.registry.*;

public class Main {
    public static void main(String[] args) throws RemoteException {
        Methods methods = new FileServer();
        System.out.println("Starting server ...");
        try {
            Registry registry = LocateRegistry.createRegistry(2029);
            registry.rebind("Machine1",methods);
            System.out.println("Server is running");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

