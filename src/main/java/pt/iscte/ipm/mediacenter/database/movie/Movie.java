package pt.iscte.ipm.mediacenter.database.movie;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.database.actor.Actor;
import pt.iscte.ipm.mediacenter.database.director.Director;
import pt.iscte.ipm.mediacenter.database.embedded.Genre;
import pt.iscte.ipm.mediacenter.database.embedded.Image;
import pt.iscte.ipm.mediacenter.database.embedded.Studio;
import pt.iscte.ipm.mediacenter.database.writer.Writer;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 17-02-2015.
 */

@Entity
public class Movie {

    @Id
    private ObjectId id;
    private String name;
    private String plot_summary;
    private String fullPlot;
    private int releaseYear;
    private int rate;
    private String country;
    private List<Actor> cast;
    private Director director;
    private List<Writer> writers;

    @Embedded
    private List<Image> images;
    private Studio studio;
    private Genre genre;

    //Constructor
    public Movie() {
    }


    //Getters
    public ObjectId getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPlot_summary(){
        return plot_summary;
    }
    public String getFullPlot(){
        return fullPlot;
    }
    public Genre getGenre(){
        return genre;
    }
    public Studio getStudio(){
        return studio;
    }
    public List<Writer> getWriters(){
        return writers;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public int getRate() {
        return rate;
    }
    public List<Actor> getActorsList() {
        return cast;
    }
    public Director getDirector() {
        return director;
    }
    public List<Image> getScreenShots() {
        return images;
    }
    public String getCountry(){
        return country;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setPlot_summary(String plot_summary){
        this.plot_summary = plot_summary;
    }

    public void setFullPlot(String fullPlot){
        this.fullPlot = fullPlot;
    }

    public void rate(int rate) {
        this.rate = rate;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void addWriter(Writer w){
        writers.add(w);
    }

    public void setDirector(Director d) {
        this.director = d;
    }

    public void addActorToCast(Actor a) {
        cast.add(a);
    }

    public void addImageToScreenShots(Image i) {
        images.add(i);
    }

    public void setStudio(Studio s){
        this.studio = s;
    }

    public void setGenre(Genre g){
        this.genre = genre;
    }

}
