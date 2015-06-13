package pt.iscte.ipm.mediacenter.core.database.movie;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
import pt.iscte.ipm.mediacenter.core.database.genre.Genre;
import pt.iscte.ipm.mediacenter.core.database.embedded.Image;
import pt.iscte.ipm.mediacenter.core.database.studio.Studio;

import java.util.List;

/**
 * Created by Admin on 17-02-2015.
 */

@Entity("movies")
public class Movie {

    @Id
    private String id;
    private String name;
    private String plotSummary;
    private String fullPlot;
    private int releaseYear;
    private float rating;
    private String country;



    @Embedded
    private List<Image> images;
    @Reference
    private Studio studio;
    @Reference
    private Genre genre;

    //Constructor
    public Movie() {
    }


    public Movie(String id, String name, String plotSummary, int releaseYear, float rating) {
        this.id = id;
        this.name = name;
        this.plotSummary = plotSummary;
        this.releaseYear=releaseYear;
        this.rating = rating;
    }


    //Getters
    public String getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPlot_summary(){
        return plotSummary;
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

    public int getReleaseYear() {
        return releaseYear;
    }
    public float getRate() {
        return rating;
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
        this.plotSummary = plotSummary;
    }

    public void setFullPlot(String fullPlot){
        this.fullPlot = fullPlot;
    }

    public void rate(double rate) {
        this.rating = rating;
    }

    public void setCountry(String country){
        this.country = country;
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
