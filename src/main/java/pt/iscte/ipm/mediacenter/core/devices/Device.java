package pt.iscte.ipm.mediacenter.core.devices;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventOutgoingWrapper;

import java.io.IOException;

public abstract class Device {
    private Session session;
    private String name;


    public Device(String name, Session session) {
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

    public void send(Event event){
        String msg = String.valueOf(new EventOutgoingWrapper(event));
        System.out.println("sending: " + msg);
        try {
            this.session.getRemote().sendString(msg);
        } catch (IOException e) {
            this.kill();
            e.printStackTrace();
        }
    }

    public abstract void register();
    public abstract void unregister();
    public abstract void kill();

}
