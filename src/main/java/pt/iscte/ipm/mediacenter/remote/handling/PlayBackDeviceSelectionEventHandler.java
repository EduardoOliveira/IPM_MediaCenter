package pt.iscte.ipm.mediacenter.remote.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.managers.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.core.events.SlaveDeviceSyncEvent;
import pt.iscte.ipm.mediacenter.events.remote.PlayBackDeviceSelectionEvent;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;
import pt.iscte.ipm.mediacenter.remote.devices.RemoteControl;

import java.util.UUID;

public class PlayBackDeviceSelectionEventHandler implements EventHandler {
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();

    @Override
    public void handle(Event event, Session session) {
        PlayBackDeviceSelectionEvent playBackSelectE = (PlayBackDeviceSelectionEvent) event;
        RemoteControl remoteControl = (RemoteControl) slaveDeviceManager.
                getDeviceByUuid(UUID.fromString(event.getUuid()));

        remoteControl.freeDevice();
        UUID masterUUID = UUID.fromString(playBackSelectE.getSelectedPlayBackDevice().getUuid());
        PlayBackDevice master = playBackDeviceManager.getDeviceByUuid(masterUUID);

        remoteControl.setMaster(master);
        remoteControl.getMaster().send(new SlaveDeviceSyncEvent(master.pojifySlaves()));

    }
}
