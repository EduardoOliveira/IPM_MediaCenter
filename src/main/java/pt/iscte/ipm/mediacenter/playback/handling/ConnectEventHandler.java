package pt.iscte.ipm.mediacenter.playback.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.managers.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.*;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

import java.util.UUID;

public class ConnectEventHandler implements EventHandler {
    PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
    SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();

    @Override
    public void handle(Event event, Session session) {
        ConnectEvent connectEvent = (ConnectEvent) event;
        PlayBackDevice playBackDevice = new PlayBackDevice(connectEvent.getDeviceName(), session, UUID.randomUUID());
        playBackDevice.register();
        System.out.println("playback devices: " + playBackDeviceManager.getDevices().size());

        playBackDevice.send(new ConnectSyncEvent(String.valueOf(playBackDevice.getUuid())));
        slaveDeviceManager.broadCast(new PlayBackDeviceSyncEvent(playBackDeviceManager.pojifyDevices()));
    }
}
