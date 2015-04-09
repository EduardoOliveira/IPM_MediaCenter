package pt.iscte.ipm.mediacenter.core.mediahandler.music;

import com.mongodb.*;
import com.mpatric.mp3agic.*;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import pt.iscte.ipm.mediacenter.core.database.Database;
import pt.iscte.ipm.mediacenter.core.database.album.Album;
import pt.iscte.ipm.mediacenter.core.database.artist.Artist;
import pt.iscte.ipm.mediacenter.core.database.song.Song;
import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
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
            /*
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


            //}
            //grava na base de dados


            MongoClient mongo = Database.getMongo();
            Morphia morphia = Database.getMorphia();

            Datastore ds = morphia.createDatastore(mongo, "media_center");

            //Insert the new song in database


            Mp3File music = null;
            try {
                music = new Mp3File(path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedTagException e) {
                e.printStackTrace();
            } catch (InvalidDataException e) {
                e.printStackTrace();
            }
            ID3v2 tag;
            if(music.hasId3v2Tag()){
                tag = music.getId3v2Tag();
            }
            else{
                tag = new ID3v22Tag();
                tag.setArtist("Unknown");
                tag.setAlbum("Unknown");
                tag.setTitle("Unknown");

            }
            String trackName = tag.getTitle();
            String artist = tag.getArtist();
            String album = tag.getAlbum();
            double length = tag.getLength();

            Artist ar = new Artist(artist);
            Album al = new Album(album, ar);
            Song s = new Song(trackName, length, ar, al);

            ds.save(s);


        }
    }
}
