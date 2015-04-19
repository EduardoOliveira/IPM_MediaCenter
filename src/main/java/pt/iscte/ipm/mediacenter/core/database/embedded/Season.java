package pt.iscte.ipm.mediacenter.core.database.embedded;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
import pt.iscte.ipm.mediacenter.core.database.tvShows.TvShow;

@Embedded
public class Season {

    @Id
    private ObjectId id;

    private int number;

    @Reference
    private TvShow tvShow;

    //Getters
    public ObjectId getId(){
        return id;
    }
    public TvShow getTvShow(){
        return tvShow;
    }
    public int getNumber(){
        return number;
    }

    //Setters
    public void setTvShow(TvShow tvs){
        this.tvShow = tvs;
    }
    public void setNumber(int n){
        this.number = n;
    }
}
