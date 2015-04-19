package pt.iscte.ipm.mediacenter.core.database.song;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
import pt.iscte.ipm.mediacenter.core.database.Genre.Genre;
import pt.iscte.ipm.mediacenter.core.database.studio.Studio;
import pt.iscte.ipm.mediacenter.core.database.producer.Producer;

@Entity("songs")
public class Song {

    @Id
    private String md5;

    private String name;
    private double runTime;
    private int trackNum;
    private String location;

    @Reference
    private Producer producer;
    @Reference
    private Studio recStudio;
    private Genre genre;

    public Song() {
    }

    public Song (String name, double runTime){
        this.name = name;
        this.runTime = runTime;
    }

    public Song(String md5, String name, double runTime,String location) {
        this.md5 = md5;
        this.name = name;
        this.runTime = runTime;
        this.location = location;
    }

    //Getters
    public String getMd5(){
        return md5;
    }
    public String getName(){
        return name;
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
    public String getLocation() {
        return location;
    }

    //Setters
    public void setName(String name){
        this.name = name;
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
    public void setMd5(String md5) {
        this.md5 = md5;
    }
    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
