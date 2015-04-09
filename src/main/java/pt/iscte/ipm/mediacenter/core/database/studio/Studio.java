package pt.iscte.ipm.mediacenter.core.database.studio;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Admin on 24-02-2015.
 */
@Entity("studios")
public class Studio {

    @Id
    private ObjectId id;
    private String name;
    public enum Type {ACTING_STUDIOS, RECORDING_STUDIOS};
    private Type type;

    //Getters
    public ObjectId getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Type getType(){
        return type;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setType(Type type) { this.type = type; }
}
