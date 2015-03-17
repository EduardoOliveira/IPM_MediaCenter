package pt.iscte.ipm.mediacenter.external.lastfm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kevinsawicki.http.HttpRequest;
import pt.iscte.ipm.mediacenter.core.utils.SettingsManager;

import java.util.Map;

public abstract class LastfmAPI {

    private static final String BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    private static String API_KEY = SettingsManager.getSetting("lastfm.api_key");

    protected ObjectMapper objectMapper = new ObjectMapper();

    public LastfmAPI(){
        //objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public HttpRequest doRequest(String method, Map<String, String> data){
        data.put("api_key",API_KEY);
        data.put("method",method);
        data.put("format","json");
        return HttpRequest.get(BASE_URL).form(data);
    }

}
