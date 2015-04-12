package pt.iscte.ipm.mediacenter.core.database.album;

import org.mongodb.morphia.annotations.*;
import pt.iscte.ipm.mediacenter.core.database.song.Song;
import pt.iscte.ipm.mediacenter.core.database.studio.Studio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity("album")
public class Album {

    @Id
    private String name;
    private long duration;
    private String genre;

    @Reference
    private Studio studio;

    @Reference
    private Set<Song> songs = new HashSet<>();

    //Contructor

    public Album() {
    }

    public Album(String name) {
        this.name = name;
    }

    public Album(String name,Set<Song> songs) {
        this.songs = songs;
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public Set<Song> getSongs() {
        return songs;
    }



    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void addSong(Song s) {
        songs.add(s);
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
