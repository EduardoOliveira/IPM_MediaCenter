package pt.iscte.ipm.mediacenter.core.mediahandler.music;

import com.mpatric.mp3agic.*;
import pt.iscte.ipm.mediacenter.core.database.album.Album;
import pt.iscte.ipm.mediacenter.core.database.album.AlbumDAO;
import pt.iscte.ipm.mediacenter.core.database.artist.Artist;
import pt.iscte.ipm.mediacenter.core.database.artist.ArtistDAO;
import pt.iscte.ipm.mediacenter.core.database.embedded.Image;
import pt.iscte.ipm.mediacenter.core.database.song.Song;
import pt.iscte.ipm.mediacenter.core.database.song.SongDAO;
import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;
import pt.iscte.ipm.mediacenter.core.utils.FileUtils;
import pt.iscte.ipm.mediacenter.core.workers.WorkersManager;
import pt.iscte.ipm.mediacenter.external.lastfm.album.AlbumApi;
import pt.iscte.ipm.mediacenter.external.lastfm.artist.ArtistApi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class MusicHandler implements MediaHandler {

    ArtistDAO artistDao = new ArtistDAO();
    AlbumDAO albumDao = new AlbumDAO();
    SongDAO songDao = new SongDAO();
    AlbumApi albumApi = new AlbumApi();
    ArtistApi artistApi = new ArtistApi();

    @Override
    public void handle(Path path) {
        if (path.toString().endsWith(".mp3"))
            WorkersManager.addRunnable(new MusicProcess(path));
    }

    private class MusicProcess implements Runnable {
        private Path path;

        public MusicProcess(Path path) {
            this.path = path;
        }

        @Override
        public void run() {
            //grava na base de dados

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
            String location = FileUtils.relativizePath(SettingsManager.getSetting("music", "dir"), path.toString());

            Song song = songDao.findOne("md5", md5);
            if (song == null) {
                song = new Song(md5, trackName, length, location);
            }

            song.setName(trackName);
            songDao.save(song);

            Album album = albumDao.findOne("name", albumName);
            if (album == null) {
                album = processAlbum(artistName, albumName);
            }
            album.addSong(song);
            albumDao.save(album);

            Artist artist = artistDao.findOne("name", artistName);
            if (artist == null) {
                artist = processArtist(artistName);
            }
            artist.addAlbum(album);
            artistDao.save(artist);
        }

        private Artist processArtist(String artistName) {
            Artist artist;
            artist = new Artist(artistName);
            pt.iscte.ipm.mediacenter.external.lastfm.artist.Artist.ArtistInfo artistInfo = artistApi.getInfo(artistName);
            for (pt.iscte.ipm.mediacenter.external.lastfm.commons.Image i : artistInfo.getImages()) {

                String path = SettingsManager.getSetting("music", "images_dir") + File.separator +
                        artist.getName().replaceAll("[^a-zA-Z0-9]", "") + "-" +
                        i.getSize() + "." + FileUtils.extractExtension(i.getUrl());
                try {
                    FileUtils.downloadFile(i.getUrl(), path);
                    artist.addImage(new Image(path, i.getSize(),
                            FileUtils.relativizePath(SettingsManager.getSetting("server","web_folder"),path)));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return artist;
        }

        private Album processAlbum(String artistName, String albumName) {
            Album album;
            album = new Album(albumName);
            pt.iscte.ipm.mediacenter.external.lastfm.album.Album albumInfo = albumApi.getInfo(albumName, artistName);
            for (pt.iscte.ipm.mediacenter.external.lastfm.commons.Image i : albumInfo.getImages()) {

                String path = SettingsManager.getSetting("music", "images_dir") + File.separator +
                        album.getName().replaceAll("[^a-zA-Z0-9]", "") + "-" +
                        i.getSize() + "." + FileUtils.extractExtension(i.getUrl());
                try {
                    FileUtils.downloadFile(i.getUrl(), path);
                    album.addImage(new Image(path, i.getSize(),
                            FileUtils.relativizePath(SettingsManager.getSetting("server", "web_folder"), path)));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            album.setReleaseDate(albumInfo.getReleaseDate().trim());
            return album;
        }
    }
}
