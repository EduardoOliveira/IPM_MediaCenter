package pt.iscte.ipm.mediacenter.external.lastfm.track;

import com.github.kevinsawicki.http.HttpRequest;
import pt.iscte.ipm.mediacenter.external.lastfm.LastfmAPI;

import java.io.IOException;
import java.util.HashMap;
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
