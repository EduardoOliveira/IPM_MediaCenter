package pt.iscte.ipm.mediacenter.mediahandler;

import java.nio.file.Path;

public interface MediaHandler extends Runnable{
    public void handle(Path p);
}
