package pt.iscte.ipm.mediacenter.core.mediahandler.serie;

import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;
import pt.iscte.ipm.mediacenter.core.mediahandler.MediaManager;
import pt.iscte.ipm.mediacenter.core.workers.WorkersManager;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesHandler implements MediaHandler {

    @Override
    public void handle(Path path) {
        String pathStr = path.toString().toLowerCase();
        if (pathStr.endsWith(".mp4") ||
            pathStr.endsWith(".mkv") ||
            !pathStr.contains("sample"))
            WorkersManager.addRunnable(new SeriesProcess(path));
    }

    private class SeriesProcess implements Runnable{
        private Path path;

        public SeriesProcess(Path path) {
            this.path = path;
        }

        @Override
        public void run() {
            Pattern patern = Pattern.compile("(.*?)[.\\\\s][sS](\\\\d{2})[eE](\\\\d{2}).*");
            Matcher matcher = patern.matcher(path.toString());
            /*
            if(matcher.matches()) {
                System.out.println("matches");
                System.exit(0);
                //System.out.println(matcher.group("showName"));
            }*/
        }
    }
}
