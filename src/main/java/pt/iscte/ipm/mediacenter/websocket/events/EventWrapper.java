package pt.iscte.ipm.mediacenter.websocket.events;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class EventWrapper {

    private String type;

    private WebSocketEvent event;

    public EventWrapper() {
    }

    public EventWrapper(WebSocketEvent event) {
        this.event = event;
        this.type = event.getClass().getCanonicalName();
    }

    public WebSocketEvent getEvent() {
        return event;
    }

    @JsonProperty("data")
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "event")
    public void setEvent(WebSocketEvent event) {
        this.event = event;
        this.type = event.getClass().getCanonicalName();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {

        try {
            return (new ObjectMapper().writeValueAsString(this));
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
