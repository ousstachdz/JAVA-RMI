import java.io.Serializable;

public class Fichier implements Serializable {

    public String name;
    public String path;
    public String extension;
    public String content;

    Fichier(String name, String path, String extension, String content){
        this.name = name;
        this.path = path;
        this.extension = extension;
        this.content = content;
    }
}