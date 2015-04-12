package pt.iscte.ipm.mediacenter.core.mediahandler.music;

import com.mpatric.mp3agic.*;
import org.mongodb.morphia.Datastore;
import pt.iscte.ipm.mediacenter.core.database.Database;
import pt.iscte.ipm.mediacenter.core.database.album.Album;
import pt.iscte.ipm.mediacenter.core.database.album.AlbumDAO;
import pt.iscte.ipm.mediacenter.core.database.artist.Artist;
import pt.iscte.ipm.mediacenter.core.database.artist.ArtistDAO;
import pt.iscte.ipm.mediacenter.core.database.song.Song;
import pt.iscte.ipm.mediacenter.core.database.song.SongDAO;
import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;
import pt.iscte.ipm.mediacenter.core.utils.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class MusicHandler implements MediaHandler {

    ArtistDAO artistDao = new ArtistDAO();
    AlbumDAO albumDao = new AlbumDAO();
    SongDAO songDao = new SongDAO();

    @Override
    public void handle(Path path) {
        if (path.toString().endsWith(".mp3"))
            new Thread(new MusicProcess(path)).start();
    }

    private class MusicProcess implements Runnable {
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

            System.out.println(path);

            Datastore ds = Database.getInstance().getDataStore();

            //Insert the new song in database


            Mp3File music = null;
            try {
                music = new Mp3File(path.toString());
            } catch (IOException | UnsupportedTagException | InvalidDataException e) {
                e.printStackTrace();
            }
            ID3v2 tag;
            if ((music != null) && music.hasId3v2Tag()) {
                tag = music.getId3v2Tag();
            } else {
                tag = new ID3v22Tag();
                tag.setArtist("Unknown");
                tag.setAlbum("Unknown");
                tag.setTitle("Unknown");

            }
            String md5 = FileUtils.digest(path.toFile(), FileUtils.DIGEST_MD5);
            String trackName = tag.getTitle();
            String artistName = tag.getArtist();
            String albumName = tag.getAlbum();
            double length = tag.getLength();
            String location = ".\\" + path.toString().substring(SettingsManager.getSetting("music", "dir").length());
            System.out.println(location);

            Song song = songDao.findOne("md5", md5);
            if (song == null) {
                song = new Song(md5, trackName, length, location);
            }
            song.setName(trackName);
            songDao.save(song);

            Album album = albumDao.findOne("name", albumName);
            if (album == null) {
                album = new Album(albumName);
            }
            album.addSong(song);
            albumDao.save(album);

            Artist artist = artistDao.findOne("name", artistName);
            if (artist == null) {
                artist = new Artist(artistName);
            }
            artist.addAlbum(album);
            artistDao.save(artist);

/*
            Song s = new Song(FileUtils.digest(path.toFile(),FileUtils.DIGEST_MD5), trackName, length,location);
            Album al = new Album(album, Arrays.asList(s));
            Artist ar = new Artist(artist,Arrays.asList(al));

            ds.save(s);
            ds.save(al);
            ds.save(ar);*/
        }
    }
}
