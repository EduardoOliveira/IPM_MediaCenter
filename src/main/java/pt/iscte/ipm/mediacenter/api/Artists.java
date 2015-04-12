package pt.iscte.ipm.mediacenter.api;

import pt.iscte.ipm.mediacenter.core.database.artist.Artist;
import pt.iscte.ipm.mediacenter.core.database.artist.ArtistDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("artists")
public class Artists {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> getArtists(){
        return (new ArtistDAO()).find().asList();
    }
}
