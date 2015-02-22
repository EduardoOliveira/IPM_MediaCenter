package pt.iscte.ipm.mediacenter.mediahandler;

import java.io.File;

public interface MediaHandler extends Runnable{
    public void handle(File f);
}
