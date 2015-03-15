package pt.iscte.ipm.mediacenter.core.database.tvShows;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import pt.iscte.ipm.mediacenter.core.database.actor.Actor;
import pt.iscte.ipm.mediacenter.core.database.director.Director;
import pt.iscte.ipm.mediacenter.core.database.embedded.*;
import pt.iscte.ipm.mediacenter.core.database.writer.Writer;

import java.util.List;

/**
 * Created by Admin on 19-02-2015.
 */
@Entity
public class TvShow {

    @Id
    private ObjectId id;
    private String name;
    private List<Actor> cast;
    private int rate;
    private String plot_summary;
    private Director director;
    private List<Writer> writers;
    private long releaseYear;
    private String country;
    private int numEpisodes;


    @Embedded
    private List<Episode> episodes;
    private List<Season> seasons;
    private List<Image> images;
    private Studio studio;
    private Genre genre;
    private Status status;



}
