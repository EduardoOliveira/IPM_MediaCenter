package pt.iscte.ipm.mediacenter.entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;

/**
 * Created by Admin on 17-02-2015.
 */

@Entity
public class Actor {

    @Id
    private int id;
    private String name;
    private String biography;
    private int age;
    private List<Movie> participations;

    //Constructor
    public Actor(String name, String biography, int age, List<Movie> participations){
        this.name = name;
        this.biography = biography;
        this.age = age;
        this.participations = participations;
    }

    //Getters
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getBiography(){
        return biography;
    }
    public int getAge(){
        return age;
    }
    public List<Movie> getParticipations(){
        return participations;
    }

    //Setters
    public void setID(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBiography(String biography){
        this.biography = biography;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void addParticipations(Movie m){
        participations.add(m);
    }

}
