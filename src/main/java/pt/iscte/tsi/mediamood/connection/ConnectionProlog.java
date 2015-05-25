package pt.iscte.tsi.mediamood.connection;

import jpl.*;
import pt.iscte.tsi.mediamood.database.entity.Movie;

import java.util.Hashtable;

/**
 * Created by Chen on 21-05-2015.
 */
public class ConnectionProlog {

    String filePath = "prologFiles/testejpl.pl";
    private ConnectionDB connectionDB;

    private static ConnectionProlog instance = null;

    public static ConnectionProlog getInstance(){
        if(instance == null){
            return new ConnectionProlog();
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

    public void insertAge(int age){

    }

    public void insertMoviesAsFacts(){
        String title;
        String cluster;

        for(Movie m: connectionDB.getMoviesForTest()){
            title = m.getTitle().replaceAll("'", "");
            cluster = m.getClusters().toString().replaceAll("\\{", "[").replaceAll("}", "]");
            Query q10 = new Query("assert(movie(\'" + title + "\'," + cluster + ", \'" + m.getGenre0() + "\'))");
            q10.query();
            System.out.println("assert(movie('" + title + "\'," + cluster + ", \'" + m.getGenre0() + "\'))");

        }
       Query q6 = new Query("movie(X,Y,Z)");

       java.util.Hashtable solution2;

        q6.query();

        while ( q6.hasMoreSolutions() ){
           solution2 = q6.nextSolution();
            System.out.println( "X = " + solution2.get("X"));
        }
    }

    public void testQuery() {
        Query q1 =
                new Query(
                        "consult",
                        new Term[] {new Atom(filePath)}
                );

       // return q1;

        System.out.println( "consult " + (q1.query() ? "succeeded" : "failed"));

        Query q2 =
                new Query(
                        "child_of",
                        new Term[] {new Atom("joe"),new Atom("X")}
                );
        Boolean resp= q2.query();
        System.out.println("child_of(joe,X) is " + resp.toString()
        );

        Query q3 =
                new Query(
                        "descendent_of",
                        new Term[] {new Atom("steve"),new Atom("ralf")}
                );

        System.out.println(
                "descendent_of(joe,ralf) is " +
                        (q3.query() ? "provable" : "not provable")
        );

        Variable X = new Variable();

        Query q4 = new Query("descendent_of(X,joe)");

        java.util.Hashtable solution;

        q4.query();

        while ( q4.hasMoreSolutions() ){
            solution = q4.nextSolution();
            System.out.println( "X = " + solution.get("X"));
        }

        Query q5 = new Query("assert(facto(bla, ble))");
        System.out.println(q5.query());

        Query q6 = new Query("facto(X,ble)");

        java.util.Hashtable solution2;

        q6.query();

        while ( q6.hasMoreSolutions() ){
            solution2 = q6.nextSolution();
            System.out.println( "X = " + solution2.get("X"));
        }

    }

}
