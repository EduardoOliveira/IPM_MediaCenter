package pt.iscte.tsi.mediamood.connection;

import jpl.Atom;
import jpl.JPL;
import jpl.Query;
import jpl.Term;

/**
 * Created by Chen on 21-05-2015.
 */
public class Connection {

    String filePath = "prologFiles/testejpl.pl";

    public void init() throws Exception{
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



}
