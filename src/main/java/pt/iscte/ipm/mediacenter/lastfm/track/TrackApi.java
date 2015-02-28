package pt.iscte.ipm.mediacenter.lastfm.track;

import com.github.kevinsawicki.http.HttpRequest;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import pt.iscte.ipm.mediacenter.lastfm.LastfmAPI;
import pt.iscte.ipm.mediacenter.lastfm.artist.ArtistApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackApi extends LastfmAPI {

    public Track search(String title,String artist) {
        Map<String,String> data = new HashMap<>();
        data.put("track",title);
        data.put("artist",artist);
        data.put("limit ","1");

        HttpRequest httpRequest = doRequest("track.search", data);

        if(httpRequest.ok()){
            String body = httpRequest.body();
            try {
                TrackSearch trackSearch = objectMapper.readValue(body,TrackSearch.class);
                return trackSearch.getResults().getTrackmatches().getTrack()[0];
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
