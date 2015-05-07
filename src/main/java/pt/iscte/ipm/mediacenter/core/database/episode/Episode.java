package pt.iscte.ipm.mediacenter.core.database.episode;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


@Entity("episode")
public class Episode {

    @Id
    private String id;
    private String name;
    private String plot;
    private String rate;
    private String firstAired; //YYYY-MM-DD
    private int season;
    private int epNum;

    public Episode(String id, String name, String plot, int season, int epNum, String rate){
        this.id =  id;
        this.name = name;
        this.plot = plot;
        this.season = season;
        this.epNum = epNum;
        this.rate = rate;
    }

    public Episode() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpNum() {
        return epNum;
    }

    public void setEpNum(int epNum) {
        this.epNum = epNum;
    }
}
