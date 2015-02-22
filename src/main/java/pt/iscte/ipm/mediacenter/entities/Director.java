package pt.iscte.ipm.mediacenter.entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;

/**
 * Created by Admin on 17-02-2015.
 */

@Entity
public class Director {

    @Id
    private int id;
    private String name;
    private int age;
    private String biography;
    private List<Movie> moviesDirected;


    //Constructor
    public Director(String name, int age, String biography, List<Movie> moviesDirected) {
        this.name = name;
        this.age = age;
        this.biography = biography;
        this.moviesDirected = moviesDirected;
    }

    //Getters
    public int getID() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public List<Movie> getDirectedMovies() {
        return moviesDirected;
    }

    //Setters
    public void setID(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBiography(String bio) {
        this.biography = bio;
    }

    public void addToDirectedMovies(Movie movie) {
        moviesDirected.add(movie);
    }

}
