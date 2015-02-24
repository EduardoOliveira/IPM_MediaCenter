package pt.iscte.ipm.mediacenter.mediahandler.movie;

import pt.iscte.ipm.mediacenter.mediahandler.MediaHandler;

import java.io.File;
import java.nio.file.Path;

public class MovieHandler implements MediaHandler {
    @Override
    public void handle(Path path) {
        System.out.println(path.toString());



    }

    @Override
    public void run() {

    }
}
