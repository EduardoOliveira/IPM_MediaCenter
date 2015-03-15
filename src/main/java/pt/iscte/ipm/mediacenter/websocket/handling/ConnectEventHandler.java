package pt.iscte.ipm.mediacenter.websocket.handling;

import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;

public class ConnectEventHandler implements EventHandler {
    @Override
    public void handle(Event event) {
        System.out.println(event);
    }
}
