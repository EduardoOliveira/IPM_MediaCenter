package pt.iscte.ipm.mediacenter.external.lastfm.album;

import com.github.kevinsawicki.http.HttpRequest;
import pt.iscte.ipm.mediacenter.external.lastfm.LastfmAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AlbumApi extends LastfmAPI {

    public Album getInfo(String title,String artist) {
        Map<String,String> data = new HashMap<>();
        data.put("album",title.replaceAll("\\(.*\\)", "").trim());
        data.put("artist",artist.replaceAll("\\(.*\\)", "").trim());
        data.put("limit ","1");

        HttpRequest httpRequest = doRequest("album.getinfo", data);

        if(httpRequest.ok()){
            String body = httpRequest.body();
            try {
                AlbumInfo albumInfo = objectMapper.readValue(body,AlbumInfo.class);
                return albumInfo.getAlbum();
            } catch (IOException e) {
                System.err.println(title.replaceAll("\\(.*\\)", "").trim());
                System.err.println(artist.replaceAll("\\(.*\\)", "").trim());
                e.printStackTrace();
            }
        }
        return null;
    }
}
