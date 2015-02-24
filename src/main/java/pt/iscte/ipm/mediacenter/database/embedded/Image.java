package pt.iscte.ipm.mediacenter.database.embedded;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Admin on 19-02-2015.
 */
@Embedded
public class Image {

    @Id
    private ObjectId id;
    private String description;
    private String path;

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

    //Setters
    public void setDescription(String d){
        this.description = d;
    }
    public void setPath(String path){
        this.path = path;
    }

}
