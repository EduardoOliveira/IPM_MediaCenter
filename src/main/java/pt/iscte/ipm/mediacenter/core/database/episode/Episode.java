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
}
