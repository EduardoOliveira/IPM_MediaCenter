package pt.iscte.ipm.mediacenter.api;



import pt.iscte.ipm.mediacenter.core.database.movie.Movie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class Movies {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAllMovies(){
        return new ArrayList<Movie>();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie getMovie(@PathParam("id") String id){
        return new Movie();
    }
}
