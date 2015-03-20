package pt.iscte.ipm.mediacenter.remote.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.*;
import pt.iscte.ipm.mediacenter.remote.devices.RemoteControl;

import java.io.IOException;

public class ConnectEventHandler implements EventHandler {
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
    private RemoteControl remoteControl;
    @Override
    public void handle(Event event,Session session) {
        ConnectEvent connectEvent = (ConnectEvent) event;
        remoteControl = new RemoteControl(connectEvent.getDeviceName(),session);
        remoteControl.register();

        PlayBackDeviceSyncEvent playBackDeviceSyncEvent = new PlayBackDeviceSyncEvent(playBackDeviceManager.pojifyDevices());
        try {
            session.getRemote().sendString(String.valueOf(new EventOutgoingWrapper(playBackDeviceSyncEvent)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("remote");
    }
}
