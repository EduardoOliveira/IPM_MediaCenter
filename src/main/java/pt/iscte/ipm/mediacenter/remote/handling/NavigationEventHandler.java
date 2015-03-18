package pt.iscte.ipm.mediacenter.remote.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;

public class NavigationEventHandler implements EventHandler{
    @Override
    public void handle(Event event,Session session) {
        NavigationEvent navigationEvent = (NavigationEvent) event;
    }
}
