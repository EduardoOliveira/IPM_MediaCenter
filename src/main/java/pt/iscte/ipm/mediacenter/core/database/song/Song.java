package pt.iscte.ipm.mediacenter.core.database.song;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.core.database.album.Album;
import pt.iscte.ipm.mediacenter.core.database.artist.Artist;
import pt.iscte.ipm.mediacenter.core.database.embedded.Genre;
import pt.iscte.ipm.mediacenter.core.database.embedded.Studio;
import pt.iscte.ipm.mediacenter.core.database.producer.Producer;

/**
 * Created by Admin on 19-02-2015.
 */
@Entity
public class Song {

    @Id
    private ObjectId id;
    private String name;
    private Album album;
    private double runTime;
    private Producer producer;
    private Studio recStudio;
    private Genre genre;
    private int trackNum;
    private Artist artist;

    public Song (String name, double runTime, Artist artist, Album album){
        this.name = name;
        this.runTime = runTime;
        this.artist = artist;
        this.album = album;
    }

    //Getters
    public ObjectId getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Album getAlbum(){
        return album;
    }
    public double getRunTime(){
        return runTime;
    }
    public Producer getProducer(){
        return producer;
    }
    public Studio getRecStudio(){
        return recStudio;
    }
    public Genre getGenre(){
        return genre;
    }
    public int getTrackNum(){
        return trackNum;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setAlbum(Album a){
        this.album = a;
    }
    public void setRunTime(int r){
        this.runTime = r;
    }
    public void setProducer(Producer p){
        this.producer = p;
    }
    public void setRecStudio(Studio s){
        this.recStudio = s;
    }
    public void setGenre(Genre g){
        this.genre = g;
    }
    public void setTrackNum(int trackNum){
        this.trackNum = trackNum;
    }

}
