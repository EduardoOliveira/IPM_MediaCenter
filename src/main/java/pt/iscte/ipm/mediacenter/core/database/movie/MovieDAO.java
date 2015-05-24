package pt.iscte.ipm.mediacenter.core.database.movie;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.database.Database;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

/**
 * Created by Admin on 19-02-2015.
 */
public class MovieDAO extends BasicDAO<Movie, String> {
    public MovieDAO(){
        super(Database.getInstance().getMongo(),Database.getInstance().getMorphia(),
                SettingsManager.getSetting("mongo","database"));

    }

    public Movie findByAlias( String alias ) {
        return getDatastore().find(Movie.class).field("aliases").containsIgnoreCase(alias).get();
    }

}
