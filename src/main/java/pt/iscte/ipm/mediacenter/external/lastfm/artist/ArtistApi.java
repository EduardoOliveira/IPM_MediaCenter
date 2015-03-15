package pt.iscte.ipm.mediacenter.external.lastfm.artist;

import com.github.kevinsawicki.http.HttpRequest;
import pt.iscte.ipm.mediacenter.external.lastfm.LastfmAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ArtistApi extends LastfmAPI{

    public Artist.ArtistInfo getInfo(String name){
        Map<String,String> data = new HashMap<>();
        data.put("artist",name);

        HttpRequest httpRequest = doRequest("artist.getInfo", data);

        if(httpRequest.ok()){
            String body = httpRequest.body();
            try {
                Artist artist = objectMapper.readValue(body,Artist.class);
                return artist.artistInfo;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
