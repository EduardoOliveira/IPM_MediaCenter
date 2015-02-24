package pt.iscte.ipm.mediacenter.database.embedded;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by Admin on 24-02-2015.
 */
@Embedded
public class Episode {

    @Id
    private ObjectId id;
    private String name;
    private String plot;
    private int rate;
    private String firstAired; //YYYY-MM-DD
    private double length;
    private Season season;
    private int epNum;

    //Getters
    public ObjectId getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPlot(){
        return plot;
    }
    public int getRate(){
        return rate;
    }
    public String getFirstAired(){
        return firstAired;
    }
    public double getLength(){
        return length;
    }
    public Season getSeason(){
        return season;
    }
    public int getEpNum(){
        return epNum;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setPlot(String plot){
        this.plot =plot;
    }
    public void setRate(int rate){
        this.rate = rate;
    }
    public void setAiredDate(String aired){
        this.firstAired = aired;
    }
    public void setLength(double length){
        this.length = length;
    }
    public void setSeason(Season s){
        this.season = s;
    }
    public void setEpNum(int epNum){
        this.epNum = epNum;
    }


}
