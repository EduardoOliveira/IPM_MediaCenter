package pt.iscte.ipm.mediacenter.core.database.actor;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.core.database.movie.Movie;

import java.util.List;

/**
 * Created by Admin on 17-02-2015.
 */

@Entity("actors")
public class Actor {

    @Id
    private ObjectId id;

    private String name;
    private String actorBiography;

    public Actor(String name){
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
        return actorBiography;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setActorBiography(String biography) {
        this.actorBiography = biography;
    }


}
