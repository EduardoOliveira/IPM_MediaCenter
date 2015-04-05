package pt.iscte.ipm.mediacenter.core.database.producer;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

/**
 * Created by Admin on 24-02-2015.
 */
public class ProducerDAO extends BasicDAO<Producer, String>{
    public ProducerDAO(Morphia morphia, MongoClient mongo){
        super(mongo, morphia, SettingsManager.getSetting("mongo","database"));
    }
}
