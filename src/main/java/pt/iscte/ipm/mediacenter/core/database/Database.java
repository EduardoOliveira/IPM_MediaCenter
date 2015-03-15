package pt.iscte.ipm.mediacenter.core.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import pt.iscte.ipm.mediacenter.core.utils.SettingsManager;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by Admin on 22-02-2015.
 */
public class Database {

    private static MongoClient mongoInst = null;
    private static Morphia morphiaInst = null;
    private static Datastore ds = null;

    private Database(){

    }

    public static synchronized MongoClient getMongo(){
        MongoCredential credential = MongoCredential.createMongoCRCredential(SettingsManager.getSetting("mongo.user"),
                SettingsManager.getSetting("mongo.authentication_db"),
                SettingsManager.getSetting("mongo.password").toCharArray());
        if(mongoInst == null){
            try {
                mongoInst = new MongoClient(new ServerAddress(SettingsManager.getSetting("mongo.server"),
                        SettingsManager.getIntegerSetting("mongo.port")), Arrays.asList(credential));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return mongoInst;
    }
    public static synchronized Morphia getMorphia(){
        if(morphiaInst == null){
            morphiaInst = new Morphia();
        }
        return morphiaInst;
    }

    public static  synchronized Datastore startDS(){
        if(ds == null){
            ds = morphiaInst.createDatastore(mongoInst, SettingsManager.getSetting("mongo.database"));
        }
        ds.ensureIndexes();
        return ds;
    }
}
