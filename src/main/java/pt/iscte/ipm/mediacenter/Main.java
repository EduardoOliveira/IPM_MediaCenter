package pt.iscte.ipm.mediacenter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import pt.iscte.ipm.mediacenter.filesystem.FolderWatch;
import pt.iscte.ipm.mediacenter.mediahandler.MediaManager;
import pt.iscte.ipm.mediacenter.utils.SettingsManager;

import java.io.File;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {

/*
        try{
            FolderWatch  folderWatch = new FolderWatch(Paths.get("C:\\Users\\KnoKer\\Desktop"));
            folderWatch.start();
        }catch(Exception e){
            System.err.println("--------------------------------------------------------");
            System.err.println("File system operations failed to start, continuing boot.");
            e.printStackTrace();
            System.err.println("--------------------------------------------------------");
        }
*/
        //MediaManager.tryManageFile(new File("http://zombieblitzkrieg.no-ip.biz/private/Series/Fargo/Season%201/v.2009.S01E13.the.title.avi"));

        Server server = new Server(SettingsManager.getIntegerSetting("port"));
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