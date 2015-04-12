package pt.iscte.ipm.mediacenter.core.filesystem;

import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FolderScanner extends Thread{

    private final MediaHandler mediaHandler;
    private final Path folder;

    public FolderScanner(Path folder,MediaHandler mediaHandler){
        this.folder = folder;
        this.mediaHandler = mediaHandler;
    }

    @Override
    public void run() {
        try {
            Files.walkFileTree(folder, fileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir)) {
                for (Path path : directoryStream) {
                    mediaHandler.handle(path);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return FileVisitResult.CONTINUE;
        }
    };
}
