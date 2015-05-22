package pt.iscte.tsi.mediamood.database.entity;

import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.database.Database;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

/**
 * Created by Chen on 21-05-2015.
 */
public class MovieDAO extends BasicDAO<Movie, String> {
    public MovieDAO(){
        super(Database.getInstance().getMongo(), Database.getInstance().getMorphia(),
                SettingsManager.getSetting("moods", "database"));
    }
}
