import java.io.Serializable;

public class Fichier implements Serializable {

    public String name;
    public String path;
    public String extension;
    public String content;

    Fichier(String name,  String content, String path, String extension){
        this.name = name;
        this.content = content;
        this.path = path;
        this.extension = extension;

    }}
