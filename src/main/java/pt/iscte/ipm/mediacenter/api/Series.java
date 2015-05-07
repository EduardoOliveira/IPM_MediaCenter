package pt.iscte.ipm.mediacenter.api;

import pt.iscte.ipm.mediacenter.core.database.tvShows.TvShow;
import pt.iscte.ipm.mediacenter.core.database.tvShows.TvShowDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("series")
public class Series {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TvShow> getSeries(){
        return (new TvShowDAO()).find().asList();
    }
}
