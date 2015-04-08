package pt.iscte.ipm.mediacenter.core.database.album;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.core.database.artist.Artist;
import pt.iscte.ipm.mediacenter.core.database.song.Song;

import java.util.List;

/**
 * Created by Admin on 19-02-2015.
 */
public class Album {

    @Id
    private String name;
    private long duration;
    private Artist artist;
    private String genre;

    @Embedded
    private List<Song> songs;


    //Contructor
    public Album(String name, Artist artist){
        this.name = name;
        this.artist = artist;

}

    //Getters
    public String getName(){
        return name;
    }
    public long getDuration(){
        return duration;
    }
    public Artist getArtist(){
        return artist;
    }
    public String getGenre(){ return genre; }
    public List<Song> getSongs(){
        return songs;
    }


    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setDuration(long duration){
        this.duration = duration;
    }
    public void setArtist(Artist artist){
        this.artist = artist;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void addSongs(Song s){
        songs.add(s);
    }
}
