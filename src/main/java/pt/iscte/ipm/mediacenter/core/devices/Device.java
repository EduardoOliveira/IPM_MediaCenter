package pt.iscte.ipm.mediacenter.core.devices;

import org.eclipse.jetty.websocket.api.Session;

import java.io.IOException;

public abstract class Device {
    private Session session;
    private String name;

    public Device() {
    }

    public Device(String name,Session session) {
        this.session = session;
        this.name = name;
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
        System.out.println("sending: "+message);
        this.session.getRemote().sendString(message);
    }

    public abstract void register() throws IOException, Exception;
}
