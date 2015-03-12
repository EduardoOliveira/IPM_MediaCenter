package pt.iscte.ipm.mediacenter.websocket.events;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.devices.Device;

public abstract class WebSocketEvent {

    @JsonIgnore
    protected Session originSession;
    @JsonIgnore
    protected Device originDevice;

    public abstract void handle();

    public Session getOriginSession() {
        return originSession;
    }

    public void setOriginSession(Session originSession) {
        this.originSession = originSession;
    }

    public Device getOriginDevice() {
        return originDevice;
    }

    public void setOriginDevice(Device originDevice) {
        this.originDevice = originDevice;
    }
}
