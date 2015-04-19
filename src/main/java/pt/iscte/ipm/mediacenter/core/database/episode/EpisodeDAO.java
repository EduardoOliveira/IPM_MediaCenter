package pt.iscte.ipm.mediacenter.core.database.episode;

import com.omertron.thetvdbapi.model.*;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.database.Database;
import pt.iscte.ipm.mediacenter.core.database.tvShows.TvShow;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

/**
 * Created by KnoKer on 16/04/2015.
 */
public class EpisodeDAO extends BasicDAO<Episode, String>

{
    public EpisodeDAO(){
        super(Database.getInstance().getMongo(), Database.getInstance().getMorphia(),
                SettingsManager.getSetting("mongo", "database"));
    }
}
