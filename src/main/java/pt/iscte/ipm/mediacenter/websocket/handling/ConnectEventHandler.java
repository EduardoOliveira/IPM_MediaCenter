package pt.iscte.ipm.mediacenter.websocket.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;

public class ConnectEventHandler implements EventHandler {
    @Override
    public void handle(Event event,Session session) {
        System.out.println(event);
    }
}
