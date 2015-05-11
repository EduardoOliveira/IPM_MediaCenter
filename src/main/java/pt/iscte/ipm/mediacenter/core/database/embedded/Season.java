package pt.iscte.ipm.mediacenter.core.database.embedded;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;
import pt.iscte.ipm.mediacenter.core.database.episode.Episode;

import java.util.HashSet;
import java.util.Set;

@Embedded
public class Season {

    private int number;

    @Reference
    private Set<Episode> episodes = new HashSet<>();

    public Season() {
    }

    public Season(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    public void addEpisode(Episode epi) {
        episodes.add(epi);
    }
}
