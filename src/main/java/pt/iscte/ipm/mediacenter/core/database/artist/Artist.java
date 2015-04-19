package pt.iscte.ipm.mediacenter.core.database.artist;

import org.mongodb.morphia.annotations.*;
import pt.iscte.ipm.mediacenter.core.database.album.Album;
import pt.iscte.ipm.mediacenter.core.database.embedded.Image;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity("artist")
public class Artist {

    @Id
    private String name;

    private List<Image> images = new ArrayList<>();

    @Reference
    private Set<Album> albums = new HashSet<>();

    public Artist() {
    }

    public Artist(String name){
        this.name = name;
    }

    public Artist(String name, Set<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album){
        albums.add(album);
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void addImage(Image image){
        this.images.add(image);
    }
}
