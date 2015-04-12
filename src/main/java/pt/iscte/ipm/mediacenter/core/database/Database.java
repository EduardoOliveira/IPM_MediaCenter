package pt.iscte.ipm.mediacenter.core.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

import java.net.UnknownHostException;
import java.util.Arrays;

public class Database {
    private static Database INSTANCE = new Database();
    private MongoClient mongo = null;
    private Morphia morphia = null;
    private Datastore ds = null;

    private Database() {
        MongoCredential credential = MongoCredential.createMongoCRCredential(SettingsManager.getSetting("mongo", "user"),
                SettingsManager.getSetting("mongo", "authentication_db"),
                SettingsManager.getSetting("mongo", "password").toCharArray());
        try {
            mongo = new MongoClient(new ServerAddress(SettingsManager.getSetting("mongo", "server"),
                    SettingsManager.getIntegerSetting("mongo", "port")), Arrays.asList(credential));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        morphia = new Morphia();
    }

    public MongoClient getMongo() {
        return mongo;
    }

    public Morphia getMorphia() {
        return morphia;
    }

    public synchronized Datastore getDataStore() {
        if (ds == null) {
            ds = morphia.createDatastore(mongo, SettingsManager.getSetting("mongo", "database"));
            ds.ensureIndexes();
        }
        return ds;
    }


    public static Database getInstance() {
        return INSTANCE;
    }
}
