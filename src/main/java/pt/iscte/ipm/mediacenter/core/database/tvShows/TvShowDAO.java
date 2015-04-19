package pt.iscte.ipm.mediacenter.core.database.tvShows;

import org.mongodb.morphia.dao.BasicDAO;
import pt.iscte.ipm.mediacenter.core.database.Database;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

import java.util.List;
import java.util.regex.Pattern;

public class TvShowDAO extends BasicDAO<TvShow, String> {
    public TvShowDAO(){
        super(Database.getInstance().getMongo(), Database.getInstance().getMorphia(),
                SettingsManager.getSetting("mongo", "database"));
    }

    public TvShow findByAlias( String alias ) {
        return getDatastore().find(TvShow.class).field("aliases").containsIgnoreCase(alias).get();
    }
}
