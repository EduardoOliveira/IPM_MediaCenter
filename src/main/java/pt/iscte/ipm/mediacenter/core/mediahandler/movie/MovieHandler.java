package pt.iscte.ipm.mediacenter.core.mediahandler.movie;

import pt.iscte.ipm.mediacenter.core.database.movie.MovieDAO;
import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;
import com.omertron.themoviedbapi.TheMovieDbApi;

import java.nio.file.Path;

public class MovieHandler implements MediaHandler {

    MovieDAO movieDAO = new MovieDAO();

    @Override
    public void handle(Path path) {
        System.out.println(path.toString());
    }

}
