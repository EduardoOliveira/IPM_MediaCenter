package pt.iscte.ipm.mediacenter.core.database.song;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.database.Database;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

public class SongDAO extends BasicDAO<Song, String>{
    public SongDAO(){
        super(Database.getInstance().getMongo(), Database.getInstance().getMorphia(),
                SettingsManager.getSetting("mongo","database"));
    }
}
