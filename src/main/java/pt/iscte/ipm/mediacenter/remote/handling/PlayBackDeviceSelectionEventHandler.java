package pt.iscte.ipm.mediacenter.remote.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.managers.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.events.remote.PlayBackDeviceSelectionEvent;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;
import pt.iscte.ipm.mediacenter.remote.devices.RemoteControl;

public class PlayBackDeviceSelectionEventHandler implements EventHandler {
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();

    @Override
    public void handle(Event event, Session session) {
        PlayBackDeviceSelectionEvent playBackSelectE = (PlayBackDeviceSelectionEvent) event;
        RemoteControl remoteControl = (RemoteControl) slaveDeviceManager.
                getDeviceByHostName(session.getRemoteAddress().getHostName());

        remoteControl.freeDevice();
        remoteControl.setMaster(playBackDeviceManager.
                getDeviceByHostName(playBackSelectE.getSelectedPlayBackDevice().getAddress()));

    }
}
