package pt.iscte.ipm.mediacenter.websocket.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.core.events.EventOutgoingWrapper;
import pt.iscte.ipm.mediacenter.core.events.Pong;

import java.io.IOException;

public class PingPongHandler implements EventHandler {
    @Override
    public void handle(Event event, Session session) {
        try {
            session.getRemote().sendString(String.valueOf(new EventOutgoingWrapper(new Pong(System.currentTimeMillis()))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
