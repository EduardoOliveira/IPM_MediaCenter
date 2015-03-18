package pt.iscte.ipm.mediacenter.remote.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.core.events.EventOutgoingWrapper;
import pt.iscte.ipm.mediacenter.core.events.PlayBackDeviceSyncEvent;

import java.io.IOException;

public class ConnectEventHandler implements EventHandler {
    PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();

    @Override
    public void handle(Event event,Session session) {
        PlayBackDeviceSyncEvent playBackDeviceSyncEvent = new PlayBackDeviceSyncEvent(playBackDeviceManager.pojifyDevices());
        try {
            session.getRemote().sendString(String.valueOf(new EventOutgoingWrapper(playBackDeviceSyncEvent)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("remote");
    }
}
