package pt.iscte.ipm.mediacenter.core.devices;

import org.eclipse.jetty.websocket.api.Session;

import java.io.IOException;

public abstract class Device {
    private Session session;
    private String name;

    public Device() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void send(String message) throws IOException {
        this.session.getRemote().sendString(message);
    }

    public abstract void register() throws IOException, Exception;
}
