package pt.iscte.ipm.mediacenter.database.actor;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.database.movie.Movie;

import java.util.List;

/**
 * Created by Admin on 17-02-2015.
 */

@Entity
public class Actor {

    @Id
    private ObjectId id;
    private String name;
    private String biography;
    private List<Movie> participations;

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

    public List<Movie> getParticipations() {
        return participations;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void addParticipations(Movie m) {
        participations.add(m);
    }

}
