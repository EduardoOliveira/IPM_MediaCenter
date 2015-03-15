package pt.iscte.ipm.mediacenter.core.database.artist;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.utils.SettingsManager;

/**
 * Created by Admin on 19-02-2015.
 */
public class ArtistDAO extends BasicDAO<Artist, String> {
    public ArtistDAO(Morphia morphia, MongoClient mongo){
        super(mongo, morphia, SettingsManager.getSetting("mongo.database"));
    }
}
