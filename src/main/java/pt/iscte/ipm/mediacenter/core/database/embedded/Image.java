package pt.iscte.ipm.mediacenter.core.database.embedded;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

@Embedded
public class Image {

    private String description;

    @Id
    @JsonIgnore
    private String path;
    private String size;
    private String webPath;

    public Image() {
    }

    public Image(String path, String size, String webPath) {
        this.size = size;
        this.path = path;
        this.webPath = webPath;
    }

    //Getters
    public String description(){
        return description;
    }
    public String getPath(){
        return path;
    }
    public String getDescription() {
        return description;
    }

    //Setters
    public void setDescription(String d){
        this.description = d;
    }
    public void setPath(String path){
        this.path = path;
    }

    public String getWebPath() {
        return webPath;
    }

    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
