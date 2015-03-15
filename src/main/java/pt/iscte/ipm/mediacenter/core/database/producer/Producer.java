package pt.iscte.ipm.mediacenter.core.database.producer;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.core.database.album.Album;

import java.util.List;

/**
 * Created by Admin on 24-02-2015.
 */

@Entity
public class Producer {

    @Id
    private ObjectId id;
    private String name;
    private String biography;
    private List<Album> productions;

    //Getters
    public ObjectId getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getBiography(){
        return biography;
    }
    public List<Album> getProductions(){
        return productions;
    }


    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setBiography(String biography){
        this.biography = biography;
    }
    public void addProductions(Album a){
        productions.add(a);
    }
}
