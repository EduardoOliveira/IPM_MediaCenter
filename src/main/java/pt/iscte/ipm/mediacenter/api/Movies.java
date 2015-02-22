package pt.iscte.ipm.mediacenter.api;



import pt.iscte.ipm.mediacenter.database.movie.Movie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class Movies {

    @GET
    @Produces("application/json")
    public List<Movie> getAllMovies(){
        return new ArrayList<Movie>();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Movie getMovie(@PathParam("id") String id){
        return new Movie();
    }
}
