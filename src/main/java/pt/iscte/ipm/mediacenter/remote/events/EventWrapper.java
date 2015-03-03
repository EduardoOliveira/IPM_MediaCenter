package pt.iscte.ipm.mediacenter.remote.events;

import org.codehaus.jackson.annotate.JsonTypeInfo;

public class EventWrapper {

    private RemoteEvent remoteEvent;
    private String type;
    public RemoteEvent getRemoteEvent() {
        return remoteEvent;
    }

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.EXTERNAL_PROPERTY, property="event_type")
    public void setRemoteEvent(RemoteEvent remoteEvent) {
        this.remoteEvent = remoteEvent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
