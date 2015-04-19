package pt.iscte.ipm.mediacenter.core.database.tvShows;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
import pt.iscte.ipm.mediacenter.core.database.actor.Actor;
import pt.iscte.ipm.mediacenter.core.database.director.Director;
import pt.iscte.ipm.mediacenter.core.database.episode.Episode;
import pt.iscte.ipm.mediacenter.core.database.embedded.Image;
import pt.iscte.ipm.mediacenter.core.database.embedded.Season;
import pt.iscte.ipm.mediacenter.core.database.status.Status;
import pt.iscte.ipm.mediacenter.core.database.studio.Studio;
import pt.iscte.ipm.mediacenter.core.database.writer.Writer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity("shows")
public class TvShow {

    @Id
    private String id;
    private String name;
    private int rate;
    private String plotSummary;
    private String firstAired;
    private float rating;
    private String country;
    private int numEpisodes;
    private String genre;
    private Status status;
    private Set<String> aliases = new HashSet<>();


    @Reference
    private List<Actor> cast;
    @Reference
    private List<Writer> writers;
    @Reference
    private Director director;


    @Reference
    private Set<Episode> episodes = new HashSet<>();
    @Embedded
    private List<Season> seasons;

    @Reference
    private Studio studio;

    @Embedded
    private List<Image> bannerImages = new ArrayList<>();
    @Embedded
    private List<Image> posterImages = new ArrayList<>();
    @Embedded
    private List<Image> fanArtImages = new ArrayList<>();
    @Embedded
    private List<Image> seasonImages = new ArrayList<>();


    public TvShow() {
    }

    public TvShow(String id, String name, String plotSummary, String firstAired, float rating) {
        this.id = id;
        this.name = name;
        this.plotSummary = plotSummary;
        this.firstAired = firstAired;
        this.rating = rating;
    }

    public void addBannerImages(List<Image> imgs) {
        for (Image i : imgs) {
            this.bannerImages.add(i);
        }
    }

    public void addPosterImages(List<Image> imgs) {
        for (Image i : imgs) {
            this.posterImages.add(i);
        }
    }

    public void addFanArtImages(List<Image> imgs) {
        for (Image i : imgs) {
            this.fanArtImages.add(i);
        }
    }

    public void addSeasonImages(List<Image> imgs) {
        for (Image i : imgs) {
            this.seasonImages.add(i);
        }
    }

    public Set<String> getAliases() {
        return aliases;
    }

    public void setAliases(Set<String> aliases) {
        this.aliases = aliases;
    }

    public void addAlias(String alias){
        this.aliases.add(alias);
    }

    public String getId() {
        return id;
    }

    public void addEpisode(Episode epi){
        episodes.add(epi);
    }
}
