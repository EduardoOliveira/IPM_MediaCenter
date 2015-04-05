package pt.iscte.ipm.mediacenter.core.database.director;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

/**
 * Created by Admin on 19-02-2015.
 */
public class DirectorDAO extends BasicDAO<Director, String>{
    public DirectorDAO(Morphia morphia, MongoClient mongo){
        super(mongo, morphia, SettingsManager.getSetting("mongo","database"));
    }
}
