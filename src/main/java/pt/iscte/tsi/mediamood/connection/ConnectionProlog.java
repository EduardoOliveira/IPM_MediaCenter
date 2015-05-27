package pt.iscte.tsi.mediamood.connection;

import jpl.*;
import pt.iscte.tsi.mediamood.database.entity.Movie;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Chen on 21-05-2015.
 */
public class ConnectionProlog {

    String filePath = "prologFiles/testejpl.pl";
    private ConnectionDB connectionDB;
    private List<Movie> moviesForList = new ArrayList<>();

    private static ConnectionProlog instance = null;

    public static ConnectionProlog getInstance(){
        if(instance == null){
            instance =  new ConnectionProlog();
        }

        return instance;
    }

    public void init() throws Exception{
        connectionDB = new ConnectionDB();
        JPL.init();
        Query consultQuery = new Query("consult", new Term[] {
                new Atom(filePath)});
        if (! consultQuery.hasSolution()) {
            throw new Exception("File not found: " + filePath);
        }
        consultQuery.close();

    }

    public void destroy() throws Exception {
        Query haltQuery = new Query("halt");
        haltQuery.hasSolution();
        haltQuery.close();
    }

    public List<Movie> getMoviesForEmotion(List<Movie> movies){
        List<Movie> movieForEmotion = null;
        HashMap<String, Double> genres = new HashMap<>();

        java.util.Hashtable solution;
        Query queryMovieEmotion = new Query("solve(genre(X), CF)");

        while ( queryMovieEmotion.hasMoreSolutions() ) {
            solution = queryMovieEmotion.nextSolution();
            genres.put(String.valueOf(solution.get("X")), Double.valueOf(String.valueOf(solution.get("CF"))));
        }
        double biggestCF = 0.0;
        for(String s : genres.keySet()){
            if(genres.get(s) > biggestCF){
                biggestCF = genres.get(s);
            }
        }

        for(Movie m: movies){
            System.out.println(genres.get(m.getGenre0().toLowerCase()));
            if(genres.get(m.getGenre0().toLowerCase()) >= biggestCF){
               movieForEmotion = connectionDB.getByGenreWithList(m.getGenre0(), movies);
            }
        }

        return movieForEmotion;
    }

    public void introEmotion(String emotion){
        Query emot = new Query("introduce_emotion(" + emotion + ")");
        emot.query();
    }

    public void getMoviesForAge(String age){

        String title;
        String genre;
        String[] parts;

        java.util.Hashtable solution;
        Query queryAge;
        //Se age < 9 -> General Audience
        if(Integer.valueOf(age) < 9){
            //Variable X = new Variable();
            queryAge = new Query("general(X)");

            while ( queryAge.hasMoreSolutions() ) {
                solution = queryAge.nextSolution();
                parts = String.valueOf(solution.get("X")).replaceAll("['.()]", "").split(",");
                title = parts[0];
                genre = parts[1];
                System.out.println(title);
                System.out.println(parts);
                moviesForList.add(connectionDB.getMovieByTitle(title));

            }
        }
        if(Integer.valueOf(age) < 14 && Integer.valueOf(age) >= 9){
            queryAge = new Query("parental_guidance(X)");
            while ( queryAge.hasMoreSolutions() ) {
                solution = queryAge.nextSolution();
                parts = String.valueOf(solution.get("X")).replaceAll("['.()]", "").split(",");
                title = parts[0];
                genre = parts[1];
                moviesForList.add(connectionDB.getMovieByTitle(title));

            }
        }
        if(Integer.valueOf(age) >= 14 && Integer.valueOf(age) < 18){
            queryAge = new Query("parents_cautioned(X)");
            while ( queryAge.hasMoreSolutions() ) {
                solution = queryAge.nextSolution();
                parts = String.valueOf(solution.get("X")).replaceAll("['.()]", "").split(",");
                title = parts[0];
                genre = parts[1];
                System.out.println(title);
                moviesForList.add(connectionDB.getMovieByTitle(title));

            }
        }
        if(Integer.valueOf(age) > 18){
            queryAge = new Query("plus_18(X)");
            while ( queryAge.hasMoreSolutions() ) {
                solution = queryAge.nextSolution();
                parts = String.valueOf(solution.get("X")).replaceAll("['.()]", "").split(",");
                title = parts[0];
                genre = parts[1];
                System.out.println(title);
                moviesForList.add(connectionDB.getMovieByTitle(title));

            }
        }

    }
    public List<Movie> getMoviesForList(){
        return moviesForList;
    }

    public void insertMoviesAsFacts(){
        String title;
        String cluster;

        for(Movie m: connectionDB.getMoviesForTest()){
            title = m.getTitle().replaceAll("'", "");
            System.out.println(title);
            cluster = m.getClusters().toString().replaceAll("\\{", "[").replaceAll("}", "]");
            //System.out.println("merda?assert(movie(\'" + title + "\'," + cluster + ", \'" + m.getGenre0() + "\'))");
            Query q10 = new Query("assert(movie(\'" + title + "\'," + cluster + ", \'" + m.getGenre0() + "\'))");
            //q10.query();
            //System.out.println("assert(movie('" + title + "\'," + cluster + ", \'" + m.getGenre0() + "\'))");

        }

    }

    public void getAllMovies(){
        Query q6 = new Query("movie(X,Y,Z)");

        java.util.Hashtable solution2;

        q6.query();

        while ( q6.hasMoreSolutions() ){
            solution2 = q6.nextSolution();
            System.out.println( "X = " + solution2.get("X"));
        }
    }



}
