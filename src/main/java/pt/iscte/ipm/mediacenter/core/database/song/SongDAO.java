package pt.iscte.ipm.mediacenter.core.database.song;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

/**
 * Created by Admin on 24-02-2015.
 */
public class SongDAO extends BasicDAO<Song, String>{
    public SongDAO(Morphia morphia, MongoClient mongo){
        super(mongo, morphia, SettingsManager.getSetting("mongo","database"));
    }
}
