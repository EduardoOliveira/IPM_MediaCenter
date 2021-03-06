package pt.iscte.ipm.mediacenter.core.mediahandler.movie;

import com.omertron.themoviedbapi.MovieDbException;
import com.omertron.themoviedbapi.model.movie.MovieInfo;
import com.omertron.themoviedbapi.results.ResultList;
import pt.iscte.ipm.mediacenter.core.database.movie.Movie;
import pt.iscte.ipm.mediacenter.core.database.movie.MovieDAO;
import pt.iscte.ipm.mediacenter.core.database.embedded.Image;
import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;
import com.omertron.themoviedbapi.TheMovieDbApi;
import com.omertron.themoviedbapi.model.artwork.Artwork;

import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;
import pt.iscte.ipm.mediacenter.core.utils.FileUtils;
import pt.iscte.ipm.mediacenter.core.workers.WorkersManager;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieHandler implements MediaHandler {

    MovieDAO movieDAO = new MovieDAO();
    TheMovieDbApi movieDB;

    public MovieHandler() {
        try {
            movieDB = new TheMovieDbApi(SettingsManager.getSetting("moviedb", "api_key"));
        } catch (MovieDbException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handle(Path path) {
        String pathStr = path.toString().toLowerCase();
        if ((pathStr.endsWith(".mp4") ||
                pathStr.endsWith(".mkv")) &&
                !pathStr.contains("sample"))
            WorkersManager.addRunnable(new MovieProcess(path));
    }

    private class MovieProcess implements Runnable {

        private Path path;

        public MovieProcess (Path path){this.path=path;}

        @Override
        public void run() {
            System.out.println("start");
            Pattern pattern = Pattern.compile(SettingsManager.getSetting("movies","format"));
            Matcher matcher = pattern.matcher(path.toString());
            synchronized (PlayBackDevice.class){
                System.out.println(path);
                if(matcher.find()){
                    RegexMovie regexMovie = new RegexMovie(matcher);
                    Movie movie = processMovie(regexMovie);
                    movieDAO.save(movie);

                }
                System.out.println("pending-" + WorkersManager.getPendingTasksCount());
                System.out.println("total-" + WorkersManager.getTotalTasksCount());
            }

        }
    }
    private Movie processMovie(RegexMovie regexMovie) {
        Movie movie = movieDAO.findByAlias(regexMovie.name);
        if (movie == null) {
            String searchName = regexMovie.prettyName; //+ (regexMovie.year != null ? " " + regexMovie.year : "");
            int searchYear = Integer.parseInt(regexMovie.year);
            System.out.println(searchName);
            ResultList<MovieInfo> searchMovie = null;
            try {
                searchMovie  = movieDB.searchMovie(searchName,0,"en",true, searchYear,searchYear,null);
            } catch (MovieDbException e) {
                e.printStackTrace();
            }
            if (!searchMovie.isEmpty()) {
                MovieInfo foundMovie = null;
                try {
                    foundMovie = movieDB.getMovieInfo(searchMovie.getResults().get(0).getId(), "en");
                } catch (MovieDbException e) {
                    e.printStackTrace();
                }
                movie = new Movie(String.valueOf(foundMovie.getId()), foundMovie.getTitle(),foundMovie.getOverview(), Integer.parseInt(foundMovie.getReleaseDate()), foundMovie.getUserRating());
                String id = String.valueOf(searchMovie.getResults().get(0).getId());
           //     Artwork banners = movieDB.getMovieImages;
               // movie.(getBanners(banners.getSeriesList(), id));


            } else {
                System.out.println("not found");
            }
        } else {
            System.out.println("skip");
        }
        return movie;

    }
   /* private List<Image> getBanners(List<Artwork> banners, String id) {
        List<Image> images = new ArrayList<>();
        for (Artwork b : banners) {
            StringBuilder builder = new StringBuilder();
            builder.append(SettingsManager.getSetting("series", "images_dir"));
            builder.append("/");
            builder.append(id);
            builder.append("/");
            builder.append(b.getId());
            builder.append("-");
            builder.append(b.getBannerType2().toString());
            builder.append(".");
            builder.append(FileUtils.extractExtension(b.getUrl()));
            String path = builder.toString();
            try {
                FileUtils.downloadFile(b.getUrl(), path);
                images.add(new Image(path, b.getBannerType2().toString(),
                        FileUtils.relativizePath(SettingsManager.getSetting("server", "web_folder"), path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return images;
    }*/

    private class RegexMovie {
        String name = "";
        String prettyName = "";
        String year = "";

        public RegexMovie(Matcher matcher) {
            name = matcher.group("ShowNameA");
            prettyName = matcher.group("ShowNameA").replaceAll("[._]", " ");

            if (matcher.group("ShowYearA") != null) {
                year = matcher.group("ShowYearA");
            }

        }
    }
}


