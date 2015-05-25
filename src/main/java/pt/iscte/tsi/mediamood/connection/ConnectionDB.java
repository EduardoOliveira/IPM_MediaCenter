package pt.iscte.tsi.mediamood.connection;

import pt.iscte.tsi.mediamood.database.entity.Movie;
import pt.iscte.tsi.mediamood.database.entity.MovieDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen on 24-05-2015.
 */
public class ConnectionDB {

    private List<Movie> movies;

    private List<Movie> moviesForTest = new ArrayList<>();

    public ConnectionDB() {
        MovieDAO movieDao = new MovieDAO();
        movies = movieDao.find().asList();
        int i = 0;
        for (Movie m : movies) {
            if(m.getClusters()!= null) {
                if (i < 10) {

                    moviesForTest.add(m);
                    i++;
                }
            }
        }
    }
    public List<Movie> getMoviesForTest(){
        return moviesForTest;
    }
}
