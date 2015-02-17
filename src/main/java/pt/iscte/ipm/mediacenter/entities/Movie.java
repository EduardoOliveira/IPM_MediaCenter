package pt.iscte.ipm.mediacenter.entities;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.embedded.Image;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 17-02-2015.
 */

@Entity
public class Movie {

    @Id
    private String name;
    private Date releaseDate;
    private int rate;
    private String description;
    private List<Actor> cast;
    private Director director;

    @Embedded
    private List<Image> images;

    //Constructor
    public Movie(String name, Date releaseDate, String description, List<Actor> cast, Director director, List<Image> images){
        this.name = name;
        this.releaseDate = releaseDate;
        this.description = description;
        this.cast = cast;
        this.director = director;
        this.images = images;
    }

    //Getters
    public String getName(){
        return name;
    }
    public Date getReleaseDate(){
        return releaseDate;
    }
    public int getRate(){
        return rate;
    }
    public String getDescription(){
        return description;
    }
    public List<Actor> getActorsList(){
        return cast;
    }
    public Director getDirector(){
        return director;
    }
    public List<Image> getScreenShots(){
        return images;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setReleaseDate(){
        this.releaseDate = releaseDate;
    }
    public void rate(int rate){
        this.rate = rate;
    }
    public void setDescription(){
        this.description = description;
    }
    public void setDirector(Director d){
        this.director = d;
    }
    public void addActorToCast(Actor a){
        cast.add(a);
    }
    public void addImageToScreenShots(Image i){
        images.add(i);
    }

}
