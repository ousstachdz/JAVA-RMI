import java.rmi.Remote;

public interface Methods extends Remote {
    public Fichier getFile(String nameFichier);
}
