package pt.iscte.ipm.mediacenter.core.database.tvShows;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
import pt.iscte.ipm.mediacenter.core.database.Genre.Genre;
import pt.iscte.ipm.mediacenter.core.database.actor.Actor;
import pt.iscte.ipm.mediacenter.core.database.director.Director;
import pt.iscte.ipm.mediacenter.core.database.embedded.*;
import pt.iscte.ipm.mediacenter.core.database.status.Status;
import pt.iscte.ipm.mediacenter.core.database.studio.Studio;
import pt.iscte.ipm.mediacenter.core.database.writer.Writer;

import java.util.List;

/**
 * Created by Admin on 19-02-2015.
 */
@Entity("shows")
public class TvShow {

    @Id
    private ObjectId id;

    private String name;
    private int rate;
    private String plot_summary;
    private long releaseYear;
    private String country;
    private int numEpisodes;


    private List<Actor> cast;
    private List<Writer> writers;
    @Reference
    private Director director;


    @Embedded
    private List<Episode> episodes;
    private List<Season> seasons;
    private List<Image> images;

    @Reference
    private Studio studio;
    @Reference
    private Genre genre;
    @Reference
    private Status status;



}
