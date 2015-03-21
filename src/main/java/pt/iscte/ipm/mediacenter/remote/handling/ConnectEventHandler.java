package pt.iscte.ipm.mediacenter.remote.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.managers.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.*;
import pt.iscte.ipm.mediacenter.remote.devices.RemoteControl;

import java.io.IOException;

public class ConnectEventHandler implements EventHandler {
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();

    @Override
    public void handle(Event event,Session session) {
        ConnectEvent connectEvent = (ConnectEvent) event;
        RemoteControl remoteControl = new RemoteControl(connectEvent.getDeviceName(), session);
        remoteControl.register();

        PlayBackDeviceSyncEvent playBackDeviceSyncEvent = new PlayBackDeviceSyncEvent(playBackDeviceManager.pojifyDevices());
        remoteControl.send(playBackDeviceSyncEvent);
        System.out.println("Remotes: "+playBackDeviceManager.getDevices().size());
    }
}
