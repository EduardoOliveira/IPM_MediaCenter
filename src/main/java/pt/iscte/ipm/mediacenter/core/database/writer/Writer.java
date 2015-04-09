package pt.iscte.ipm.mediacenter.core.database.writer;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.core.database.movie.Movie;

import java.util.List;

/**
 * Created by Admin on 24-02-2015.
 */
@Entity("writers")
public class Writer {

    @Id
    private ObjectId id;
    private String name;
    private String biography;



    //Getters
    public ObjectId getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getBio(){
        return biography;
    }


    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void editBio(String newBio){
        this.biography = newBio;
    }

}
