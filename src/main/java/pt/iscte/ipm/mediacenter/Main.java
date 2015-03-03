package pt.iscte.ipm.mediacenter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import pt.iscte.ipm.mediacenter.filesystem.FolderWatch;
import pt.iscte.ipm.mediacenter.lastfm.artist.Artist;
import pt.iscte.ipm.mediacenter.lastfm.artist.ArtistApi;
import pt.iscte.ipm.mediacenter.lastfm.track.Track;
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


/*
        TrackApi trackApi = new TrackApi();
        ArtistApi artistApi = new ArtistApi();

        Track track = trackApi.search("Halo", "Machine Head");
        Artist.ArtistInfo artistInfo = artistApi.getInfo(track.getArtist());
*/

        server.join();


    }
}