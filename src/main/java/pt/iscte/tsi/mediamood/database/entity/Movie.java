package pt.iscte.tsi.mediamood.database.entity;

import org.mongodb.morphia.annotations.*;

/**
 * Created by Chen on 21-05-2015.
 */

@Entity("movies")
public class Movie {

    @Id
    private String id;

    @Embedded("Clusters")
    private Clusters clusters;

    @Property("full_desc")
    private String description;
    private String title;
    private boolean supervisioned;
    private String genre0;
    private String genre1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Clusters getClusters() {
        return clusters;
    }

    public void setClusters(Clusters clusters) {
        this.clusters = clusters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSupervisioned() {
        return supervisioned;
    }

    public void setSupervisioned(boolean supervisioned) {
        this.supervisioned = supervisioned;
    }

    public String getGenre0() {
        return genre0;
    }

    public void setGenre0(String genre0) {
        this.genre0 = genre0;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", clusters=" + clusters +
                ", supervisioned=" + supervisioned +
                ", genre0='" + genre0 + '\'' +
                ", genre1='" + genre1 + '\'' +
                '}';
    }
}
