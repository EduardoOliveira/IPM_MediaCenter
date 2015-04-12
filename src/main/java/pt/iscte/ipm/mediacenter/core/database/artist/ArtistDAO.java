package pt.iscte.ipm.mediacenter.core.database.artist;

import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.database.Database;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

public class ArtistDAO extends BasicDAO<Artist, String> {
    public ArtistDAO(){
        super(Database.getInstance().getMongo(), Database.getInstance().getMorphia(),
                SettingsManager.getSetting("mongo","database"));
    }
}
