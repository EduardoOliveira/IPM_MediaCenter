package pt.iscte.ipm.mediacenter.mediahandler;

import pt.iscte.ipm.mediacenter.mediahandler.exceptions.InvalidFileFormatException;
import pt.iscte.ipm.mediacenter.mediahandler.music.MusicHandler;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MediaManager {

    public static void tryManageFile(File file) throws InvalidFileFormatException {
        if (file.isDirectory()) {
            throw new InvalidFileFormatException("Folder is not a Media Format");
        }
        if (file.toString().endsWith(".mp3")) {
            MediaHandler musMediaHandler = new MusicHandler();
            //musMediaHandler.handle(file);
            //new Thread(musMediaHandler).start();
        } else if (file.toString().endsWith(".mp4") || file.toString().endsWith(".mkv")) {
            tryManageVideo(file);
        }
    }

    public static void tryManageVideo(File file) {
        if (file.toString().toLowerCase().contains("sample")) {
            return;
        }
        Pattern patern = Pattern.compile(
                "^(" +
                        "  (?<ShowNameA>.*[^ (_.]) # Show name" +
                        "    [ (_.]+" +
                        "    ( # Year with possible Season and Episode" +
                        "      (?<ShowYearA>\\d{4})" +
                        "      ([ (_.]+S(?<SeasonA>\\d{1,2})E(?<EpisodeA>\\d{1,2}))?" +
                        "    | # Season and Episode only" +
                        "      (?<!\\d{4}[ (_.])" +
                        "      S(?<SeasonB>\\d{1,2})E(?<EpisodeB>\\d{1,2})" +
                        "    | # Alternate format for episode" +
                        "      (?<EpisodeC>\\d{3})" +
                        "    )" +
                        "|" +
                        "  # Show name with no other information" +
                        "  (?<ShowNameB>.+)" +
                        ")");
        System.out.println(file.getName());
        Matcher matcher = patern.matcher(file.getName());
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
        try {
            System.out.println(matcher.group("ShowNameA"));
        } catch (Exception e) {
        }
        try {
            System.out.println(matcher.group("ShowYearA"));
        } catch (Exception e) {
        }
        try {
            System.out.println(matcher.group("SeasonA"));
        } catch (Exception e) {
        }
        try {
            System.out.println(matcher.group("EpisodeA"));
        } catch (Exception e) {
        }
        try {
            System.out.println(matcher.group("SeasonB"));
        } catch (Exception e) {
        }
        try {
            System.out.println(matcher.group("EpisodeB"));
        } catch (Exception e) {
        }
        try {
            System.out.println(matcher.group("EpisodeC"));
        } catch (Exception e) {
        }
        try {
            System.out.println(matcher.group("ShowNameB"));
        } catch (Exception e) {
        }
    }
}
