package pt.iscte.ipm.mediacenter.database.writer;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.utils.SettingsManager;

/**
 * Created by Admin on 24-02-2015.
 */
public class WriterDAO extends BasicDAO<Writer, String> {
    public WriterDAO(Morphia morphia, MongoClient mongo){
        super(mongo, morphia, SettingsManager.getSetting("mongo.database"));

    }
}
