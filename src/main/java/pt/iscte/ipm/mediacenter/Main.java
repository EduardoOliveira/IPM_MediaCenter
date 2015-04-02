package pt.iscte.ipm.mediacenter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import pt.iscte.ipm.mediacenter.core.utils.SettingsManager;

import java.net.InetAddress;
import java.net.InetSocketAddress;


public class Main {
    public static void main(String[] args) throws Exception {

/*        FolderWatch moviesWatch = new FolderWatch(Paths.get(SettingsManager.getSetting("movies.dir")),new MovieHandler());
        moviesWatch.start();

        FolderWatch seriesWatch = new FolderWatch(Paths.get(SettingsManager.getSetting("series.dir")),new SerieHandler());
        seriesWatch.start();

        FolderWatch musicWatch = new FolderWatch(Paths.get(SettingsManager.getSetting("music.dir")),new MusicHandler());
        musicWatch.start();*/

        Server server = new Server(new InetSocketAddress(InetAddress.getByName("0.0.0.0"), SettingsManager.getIntegerSetting("port")));
        //Server server = new Server(SettingsManager.getIntegerSetting("port"));
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