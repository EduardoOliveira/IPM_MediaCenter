package pt.iscte.ipm.mediacenter.remote.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;
import pt.iscte.ipm.mediacenter.events.remote.NavigationSyncEvent;
import pt.iscte.ipm.mediacenter.remote.devices.RemoteControl;

public class NavigationEventHandler implements EventHandler{
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();

    @Override
    public void handle(Event event,Session session) {
        NavigationEvent navigationEvent = (NavigationEvent) event;
        RemoteControl remoteControl = (RemoteControl)slaveDeviceManager.
                getDeviceByHostName(session.getRemoteAddress().getHostName());
        remoteControl.getCurrentPlayBackDevice().broadCastToAll(new NavigationSyncEvent(navigationEvent));
    }
}
