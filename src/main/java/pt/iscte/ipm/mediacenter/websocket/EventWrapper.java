package pt.iscte.ipm.mediacenter.websocket;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.iscte.ipm.mediacenter.core.events.Event;

import java.io.IOException;

public class EventWrapper {
    private String event;

    private Event data;

    public EventWrapper() {
    }

    public EventWrapper(Event data) {
        this.data = data;
        this.event = data.getClass().getCanonicalName();
    }

    public Event getData() {
        return this.data;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "event")
    public void setData(Event data) {
        this.data = data;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String toString() {
        try {
            return (new ObjectMapper()).writeValueAsString(this);
        } catch (IOException var2) {
            var2.printStackTrace();
            return var2.toString();
        }
    }
}
