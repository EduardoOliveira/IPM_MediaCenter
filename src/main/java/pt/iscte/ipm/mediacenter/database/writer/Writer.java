package pt.iscte.ipm.mediacenter.database.writer;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.database.movie.Movie;

import java.util.List;

/**
 * Created by Admin on 24-02-2015.
 */
@Entity
public class Writer {

    @Id
    private ObjectId id;
    private String name;
    private String biography;
    private List<Movie> writtings;


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
    public List<Movie> getWrittings(){
        return writtings;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void editBio(String newBio){
        this.biography = newBio;
    }
    public void addMovieToWrittings(Movie m){
        writtings.add(m);
    }
}
