package pt.iscte.ipm.mediacenter.core.mediahandler.serie;

import com.omertron.thetvdbapi.TheTVDBApi;
import com.omertron.thetvdbapi.model.Banner;
import com.omertron.thetvdbapi.model.Banners;
import com.omertron.thetvdbapi.model.Series;
import pt.iscte.ipm.mediacenter.core.database.episode.Episode;
import pt.iscte.ipm.mediacenter.core.database.embedded.Image;
import pt.iscte.ipm.mediacenter.core.database.episode.EpisodeDAO;
import pt.iscte.ipm.mediacenter.core.database.tvShows.TvShow;
import pt.iscte.ipm.mediacenter.core.database.tvShows.TvShowDAO;
import pt.iscte.ipm.mediacenter.core.mediahandler.MediaHandler;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;
import pt.iscte.ipm.mediacenter.core.utils.FileUtils;
import pt.iscte.ipm.mediacenter.core.workers.WorkersManager;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesHandler implements MediaHandler {
    TheTVDBApi tvDB = new TheTVDBApi(SettingsManager.getSetting("tvdb", "api_key"));
    TvShowDAO tvShowDAO = new TvShowDAO();
    EpisodeDAO episodeDao = new EpisodeDAO();

    @Override
    public void handle(Path path) {
        String pathStr = path.toString().toLowerCase();
        if ((pathStr.endsWith(".mp4") ||
                pathStr.endsWith(".mkv")) &&
                !pathStr.contains("sample"))
            WorkersManager.addRunnable(new SeriesProcess(path));
    }

    private class SeriesProcess implements Runnable {
        private Path path;

        public SeriesProcess(Path path) {
            this.path = path;
        }

        @Override
        public void run() {
            System.out.println("start");
            Pattern pattern = Pattern.compile(SettingsManager.getSetting("series", "format"));
            Matcher matcher = pattern.matcher(path.toString());
            synchronized (PlayBackDevice.class) {
                System.out.println(path);
                if (matcher.find()) {
                    RegexShow regexShow = new RegexShow(matcher);
                    TvShow tvShow = processShow(regexShow);
                    try {
                        com.omertron.thetvdbapi.model.Episode epiFromAPI = tvDB.getEpisode(tvShow.getId(),
                                Integer.parseInt(regexShow.season), Integer.parseInt(regexShow.episode), "en");
                        Episode episode = new Episode(epiFromAPI.getId(), epiFromAPI.getEpisodeName(),
                                epiFromAPI.getOverview(), epiFromAPI.getSeasonNumber(),
                                epiFromAPI.getEpisodeNumber(), epiFromAPI.getRating());
                        tvShow.addEpisode(episode);
                        episodeDao.save(episode);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    tvShowDAO.save(tvShow);

                }
                System.out.println("pending-" + WorkersManager.getPendingTasksCount());
                System.out.println("total-" + WorkersManager.getTotalTasksCount());
            }

        }

        private TvShow processShow(RegexShow regexShow) {
            TvShow tvShow = tvShowDAO.findByAlias(regexShow.name);
            if (tvShow == null) {
                String searchName = regexShow.prettyName + (regexShow.year != null ? " " + regexShow.year : "");
                System.out.println(searchName);
                List<Series> searchSeries = tvDB.searchSeries(searchName, "en");
                if (searchSeries.size() > 0) {
                    Series foundSeries = tvDB.getSeries(searchSeries.get(0).getId(), "en");
                    tvShow = new TvShow(foundSeries.getId(), foundSeries.getSeriesName(),
                            foundSeries.getOverview(), foundSeries.getFirstAired(),
                            Float.parseFloat(foundSeries.getRating()));
                    String id = searchSeries.get(0).getId();
                    Banners banners = tvDB.getBanners(id);
                    tvShow.addBannerImages(getBanners(banners.getSeriesList(), id));
                    tvShow.addPosterImages(getBanners(banners.getPosterList(), id));
                    tvShow.addFanArtImages(getBanners(banners.getFanartList(), id));
                    tvShow.addSeasonImages(getBanners(banners.getSeasonList(), id));
                    tvShow.addAlias(regexShow.name);

                } else {
                    System.out.println("not found");
                }
            } else {
                System.out.println("skip");
            }
            return tvShow;
        }

        private List<Image> getBanners(List<Banner> banners, String id) {
            List<Image> images = new ArrayList<>();
            for (Banner b : banners) {
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
        }


        private class RegexShow {
            String name = "";
            String prettyName = "";
            String season = "";
            String episode = "";
            String year = "";

            public RegexShow(Matcher matcher) {
                name = matcher.group("ShowNameA");
                prettyName = matcher.group("ShowNameA").replaceAll("[._]", " ");

                if (matcher.group("ShowYearA") != null) {
                    year = matcher.group("ShowYearA");
                }
                if(matcher.group("SeasonA") != null){
                    season = matcher.group("SeasonA");
                }
                if(matcher.group("EpisodeA") != null){
                    episode = matcher.group("EpisodeA");
                }
                if (Objects.equals(season, "") && matcher.group("SeasonB") != null) {
                    season = matcher.group("SeasonB");
                }
                if (Objects.equals(episode, "") && matcher.group("EpisodeB") != null) {
                    episode = matcher.group("EpisodeB");
                } else if (Objects.equals(episode, "") && matcher.group("EpisodeB") != null) {
                    episode = matcher.group("EpisodeC");
                }
            }
        }
    }

}
