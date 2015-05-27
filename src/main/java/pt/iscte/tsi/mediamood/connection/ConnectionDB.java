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
    private MovieDAO movieDAO;

    public ConnectionDB() {
        movieDAO = new MovieDAO();
        movies = movieDAO.find().asList();
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

    public List<Movie> getByGenreWithList (String genre, List<Movie> moviesToCheck){
        List<Movie> moviesOfGenre = new ArrayList<>();
        for(Movie m : moviesToCheck){
            if(m.getGenre0().equals(genre)){
                moviesOfGenre.add(m);
            }
        }
        return moviesOfGenre;
    }

    public Movie getMovieByTitle(String title){
        for(Movie m : movies){
            if(m.getTitle().equals(title)){
                return m;
            }
        }
        return null;
    }

    public List<Movie> getMoviesForTest(){
        return moviesForTest;
    }
}
