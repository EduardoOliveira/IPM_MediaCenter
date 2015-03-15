package pt.iscte.ipm.mediacenter.core.database.artist;

import org.mongodb.morphia.annotations.Id;

/**
 * Created by Admin on 19-02-2015.
 */
public class Artist {

    @Id
    private String name;

    public Artist(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }
}
