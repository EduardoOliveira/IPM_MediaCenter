package pt.iscte.ipm.mediacenter.core.mediahandler.movie;

import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;

import java.nio.file.Path;

public class MovieHandler implements MediaHandler {
    @Override
    public void handle(Path path) {
        System.out.println(path.toString());



    }
}
