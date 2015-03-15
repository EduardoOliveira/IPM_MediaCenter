package pt.iscte.ipm.mediacenter.websocket;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.ObjectMapper;
import pt.iscte.ipm.mediacenter.core.events.Event;

import java.io.IOException;

public class EventWrapper {

    private String type;
    private String handler;
    private Event event;

    public EventWrapper() {
    }

    public EventWrapper(Event event) {
        this.event = event;
        this.type = event.getClass().getCanonicalName();
    }

    public Event getEvent() {
        return event;
    }

    @JsonProperty("data")
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "event")
    public void setEvent(Event event) {
        this.event = event;
        this.type = event.getClass().getCanonicalName();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
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
