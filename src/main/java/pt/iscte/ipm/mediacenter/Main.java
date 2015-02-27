package pt.iscte.ipm.mediacenter;

import de.umass.lastfm.Track;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import pt.iscte.ipm.mediacenter.filesystem.FolderWatch;
import pt.iscte.ipm.mediacenter.lastfm.track.TrackApi;
import pt.iscte.ipm.mediacenter.mediahandler.MediaManager;
import pt.iscte.ipm.mediacenter.mediahandler.movie.MovieHandler;
import pt.iscte.ipm.mediacenter.mediahandler.music.MusicHandler;
import pt.iscte.ipm.mediacenter.mediahandler.serie.SerieHandler;
import pt.iscte.ipm.mediacenter.utils.SettingsManager;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws Exception {

/*        FolderWatch moviesWatch = new FolderWatch(Paths.get(SettingsManager.getSetting("movies.dir")),new MovieHandler());
        moviesWatch.start();
f
        FolderWatch seriesWatch = new FolderWatch(Paths.get(SettingsManager.getSetting("series.dir")),new SerieHandler());
        seriesWatch.start();

        FolderWatch musicWatch = new FolderWatch(Paths.get(SettingsManager.getSetting("music.dir")),new MusicHandler());
        musicWatch.start();*/

        Server server = new Server(SettingsManager.getIntegerSetting("port"));
        WebAppContext context = new WebAppContext();
        context.setDescriptor("web/WEB-INF/web.xml");
        context.setResourceBase("web");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        server.start();

        TrackApi trackApi = new TrackApi();
        trackApi.search("Halo","Machine Head");

        //Collection<Track> search = Track.search("Machine Head","Halo", 1, SettingsManager.getSetting("lastfm.api_key"));



        server.join();


    }
}