package pt.iscte.ipm.mediacenter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import pt.iscte.ipm.mediacenter.core.filesystem.FolderScanner;
import pt.iscte.ipm.mediacenter.core.filesystem.FolderWatch;
import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;
import pt.iscte.ipm.mediacenter.core.mediahandler.music.MusicHandler;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws Exception {

        FolderScanner folderScanner = new FolderScanner(Paths.get(SettingsManager.getSetting("music","dir")), new MusicHandler());
        folderScanner.start();

        /*
        FolderWatch moviesWatch = new FolderWatch(Paths.get(SettingsManager.getSetting("movies.dir")),new MovieHandler());
        moviesWatch.start();

        FolderWatch seriesWatch = new FolderWatch(Paths.get(SettingsManager.getSetting("series.dir")),new SerieHandler());
        seriesWatch.start();

        FolderWatch musicWatch = new FolderWatch(Paths.get(SettingsManager.getSetting("music", "dir")), new MusicHandler());
        musicWatch.start();*/


        Server server = new Server(new InetSocketAddress(
                InetAddress.getByName(SettingsManager.getSetting("server", "interface")),
                SettingsManager.getIntegerSetting("server", "port")));
        WebAppContext context = new WebAppContext();
        context.setDescriptor("web/WEB-INF/web.xml");
        context.setResourceBase("web");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        server.start();
        server.join();
    }
}