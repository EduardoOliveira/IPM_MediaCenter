package pt.iscte.ipm.mediacenter.remote.handling;

import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;

public class NavigationEventHandler implements EventHandler{
    @Override
    public void handle(Event event) {
        NavigationEvent navigationEvent = (NavigationEvent) event;
    }
}
