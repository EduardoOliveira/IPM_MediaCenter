package pt.iscte.ipm.mediacenter.playback.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.managers.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.ConnectEvent;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

public class ConnectEventHandler implements EventHandler {
    PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();

    @Override
    public void handle(Event event, Session session) {
        ConnectEvent connectEvent = (ConnectEvent) event;
        PlayBackDevice playBackDevice = new PlayBackDevice(connectEvent.getDeviceName(), session);
        playBackDevice.register();
        System.out.println("playback devices: " + playBackDeviceManager.getDevices().size());
    }
}
