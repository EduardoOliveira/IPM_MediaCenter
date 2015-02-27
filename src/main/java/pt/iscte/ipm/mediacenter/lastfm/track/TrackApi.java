package pt.iscte.ipm.mediacenter.lastfm.track;

import com.github.kevinsawicki.http.HttpRequest;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import pt.iscte.ipm.mediacenter.lastfm.LastfmAPI;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackApi extends LastfmAPI {

    public List<Track> search(String title,String artist) {
        Map<String,String> data = new HashMap<>();
        data.put("track",title);
        data.put("artist",artist);
        data.put("limit ","1");

        HttpRequest httpRequest = doRequest("track.search", data);

        if(httpRequest.ok()){
            String body = httpRequest.body();
            System.out.println(body);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            try {
                Results trackSearchResult = objectMapper.readValue(body,Results.class);
                System.out.println(trackSearchResult.results.trackmatches.track.get(0).url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
