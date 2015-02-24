package pt.iscte.ipm.mediacenter.filesystem;

import pt.iscte.ipm.mediacenter.mediahandler.MediaHandler;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FolderWatch extends Thread {

    private MediaHandler mediaHandler;
    private Path folder;
    private WatchService watchService;

    public FolderWatch(Path folder, MediaHandler mediaHandler) throws IOException {
        this.folder = folder;
        this.mediaHandler = mediaHandler;
        this.watchService = folder.getFileSystem().newWatchService();
        Files.walkFileTree(folder, fileVisitor);
    }

    @Override
    public void run() {
        WatchKey key;
        while (true) {
            try {
                key = watchService.take();

                for (WatchEvent event : key.pollEvents()) {
                    System.out.println(((Path) key.watchable()).toString());
                    Path thisPath = ((Path) key.watchable()).resolve(event.context().toString());
                    System.out.println(thisPath.toFile().toString());
                    System.out.println(event.kind().name());
                    // Overflow event
                    if (event.kind() == StandardWatchEventKinds.OVERFLOW) {
                        continue; // loop
                    }
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE || event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        if (thisPath.toFile().exists()){
                            if(thisPath.toFile().isDirectory()) {
                                Files.walkFileTree(thisPath, fileVisitor);
                            }else{
                                System.out.println("Handle");
                                mediaHandler.handle(thisPath);
                            }
                        }
                    }else if(event.kind() == StandardWatchEventKinds.ENTRY_DELETE){
                        key.cancel();
                    }
                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    final SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

            return FileVisitResult.CONTINUE;
        }
    };
}
