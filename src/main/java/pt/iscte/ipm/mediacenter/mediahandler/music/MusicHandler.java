package pt.iscte.ipm.mediacenter.mediahandler.music;

import pt.iscte.ipm.mediacenter.mediahandler.MediaHandler;
import pt.iscte.ipm.mediacenter.utils.SettingsManager;

import java.nio.file.Path;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MusicHandler implements MediaHandler{
    @Override
    public void handle(Path path) {
        if(path.toString().endsWith(".mp3"))
            new Thread(new MusicProcess(path)).start();
    }

    private class MusicProcess implements Runnable{
        private Path path;
        public MusicProcess(Path path) {
            this.path = path;
        }

        @Override
        public void run() {
            //Pattern patern = Pattern.compile(SettingsManager.getSetting("music.dir"));
            Pattern patern = Pattern.compile("\\\\(?<artist>.*)\\\\(?<album>.*)\\\\(?<track>.*)-(?<title>.*)\\.(?<ext>.\\w+)$");

            Matcher matcher = patern.matcher(path.toString());
            if(matcher.matches()){
                String artist = matcher.group("artist");
                String album = matcher.group("album");
                String track = matcher.group("track");
                String title = matcher.group("title");
                System.out.println(artist);
                System.out.println(album);
                System.out.println(title);
/*                Collection<Track> search = Track.search(artist, title, 1, SettingsManager.getSetting("lastfm.api_key"));
                for(Track t: search){
                    System.out.println(t.toString());
                }*/
            }
            //grava na base de dados
        }
    }
}
