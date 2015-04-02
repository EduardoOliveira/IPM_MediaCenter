package pt.iscte.ipm.mediacenter.remote.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;
import pt.iscte.ipm.mediacenter.events.remote.NavigationSyncEvent;
import pt.iscte.ipm.mediacenter.remote.devices.RemoteControl;

import java.util.UUID;

public class NavigationEventHandler implements EventHandler {
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();

    @Override
    public void handle(Event event, Session session) {
        RemoteControl remoteControl = (RemoteControl) slaveDeviceManager.getDeviceByUuid(UUID.fromString(event.getUuid()));
        if (!remoteControl.isFree()) {
            NavigationEvent navigationEvent = (NavigationEvent) event;
            remoteControl.getMaster().broadCastToAll(new NavigationSyncEvent(navigationEvent));
        }
    }
}
