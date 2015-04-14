package pt.iscte.ipm.mediacenter.core.database.embedded;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

@Embedded
public class Image {

    @Id
    private ObjectId id;
    private String description;
    private String path;
    private String size;

    public Image() {
    }

    public Image(String path, String size) {
        this.size = size;
        this.path = path;
    }

    //Getters
    public ObjectId getId(){
        return id;
    }
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
    public void setId(ObjectId id) {
        this.id = id;
    }
}
