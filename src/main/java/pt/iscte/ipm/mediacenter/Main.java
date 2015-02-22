package pt.iscte.ipm.mediacenter;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import pt.iscte.ipm.mediacenter.filesystem.FolderWatch;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {

        try{
            FolderWatch  folderWatch = new FolderWatch(Paths.get("z:\\knoker.no-ip.org\\transmission"));
            folderWatch.start();
        }catch(Exception e){
            System.err.println("--------------------------------------------------------");
            System.err.println("File system operations failed to start, continuing boot.");
            e.printStackTrace();
            System.err.println("--------------------------------------------------------");
        }

        Server server = new Server(8080);
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