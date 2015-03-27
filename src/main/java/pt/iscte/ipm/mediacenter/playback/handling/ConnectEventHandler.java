package pt.iscte.ipm.mediacenter.playback.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.managers.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.*;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

public class ConnectEventHandler implements EventHandler {
    PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
    SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();

    @Override
    public void handle(Event event, Session session) {
        ConnectEvent connectEvent = (ConnectEvent) event;
        PlayBackDevice playBackDevice = new PlayBackDevice(connectEvent.getDeviceName(), session);
        playBackDevice.register();
        System.out.println("playback devices: " + playBackDeviceManager.getDevices().size());
        playBackDevice.send(new ConnectSyncEvent(playBackDevice.getSession().getRemoteAddress().getHostName()));
        slaveDeviceManager.broadCast(new PlayBackDeviceSyncEvent(playBackDeviceManager.pojifyDevices()));
    }
}
