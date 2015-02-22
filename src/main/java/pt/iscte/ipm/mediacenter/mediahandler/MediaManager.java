package pt.iscte.ipm.mediacenter.mediahandler;

import pt.iscte.ipm.mediacenter.mediahandler.exceptions.InvalidFileFormatException;
import pt.iscte.ipm.mediacenter.mediahandler.music.MusicHandler;

import java.io.File;
import java.util.regex.Pattern;


public class MediaManager {

    public static void tryManageFile(File file) throws InvalidFileFormatException {
        if(file.isDirectory()) {
            throw new InvalidFileFormatException("Folder is not a Media Format");
        }
        if(file.toString().endsWith(".mp3")){
            MediaHandler musMediaHandler = new MusicHandler();
            musMediaHandler.handle(file);
            new Thread(musMediaHandler).start();
        }else if(file.toString().endsWith(".mp4")||file.toString().endsWith(".mkv")){
            tryManageVideo(file);
        }
    }

    public static void tryManageVideo(File file) {
        if(file.toString().toLowerCase().contains("sample")){
            return;
        }
        Pattern patern = Pattern.compile(
                "^(" +
                "  (?P<ShowNameA>.*[^ (_.]) # Show name" +
                "    [ (_.]+" +
                "    ( # Year with possible Season and Episode" +
                "      (?P<ShowYearA>\\d{4})" +
                "      ([ (_.]+S(?P<SeasonA>\\d{1,2})E(?P<EpisodeA>\\d{1,2}))?" +
                "    | # Season and Episode only" +
                "      (?<!\\d{4}[ (_.])" +
                "      S(?P<SeasonB>\\d{1,2})E(?P<EpisodeB>\\d{1,2})" +
                "    | # Alternate format for episode" +
                "      (?P<EpisodeC>\\d{3})" +
                "    )" +
                "|" +
                "  # Show name with no other information" +
                "  (?P<ShowNameB>.+)" +
                ")");
    }
}
