package pt.iscte.ipm.mediacenter.core.database.director;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.core.database.movie.Movie;

import java.util.List;

/**
 * Created by Admin on 17-02-2015.
 */

@Entity("directors")
public class Director {

    @Id
    private ObjectId id;
    private String name;
    private String biography;


    public Director(String name){
        this.name = name;
    }

    //Getters
    public ObjectId getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }



    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBiography(String bio) {
        this.biography = bio;
    }



}
