package pt.iscte.ipm.mediacenter.core.events;

import org.eclipse.jetty.websocket.api.Session;

public interface EventHandler {
    public void handle(Event event,Session session);
}
