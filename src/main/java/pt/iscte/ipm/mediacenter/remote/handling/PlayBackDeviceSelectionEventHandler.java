package pt.iscte.ipm.mediacenter.remote.handling;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.devices.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.events.remote.PlayBackDeviceSelectionEvent;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;
import pt.iscte.ipm.mediacenter.remote.devices.RemoteControl;

public class PlayBackDeviceSelectionEventHandler implements EventHandler{
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
    private RemoteControl remoteControl;

    @Override
    public void handle(Event event, Session session) {
        PlayBackDeviceSelectionEvent playBackSelectE = (PlayBackDeviceSelectionEvent) event;
        remoteControl = (RemoteControl)slaveDeviceManager.getDeviceByHostName(session.getRemoteAddress().getHostName());
        PlayBackDevice currentPlayBackDevice = remoteControl.getCurrentPlayBackDevice();

        if(currentPlayBackDevice != null){
            currentPlayBackDevice.removeSlave(remoteControl);
        }
        remoteControl.registerOnPlaybackDevice(playBackDeviceManager.
                getDeviceByAddress(playBackSelectE.getSelectedPlayBackDevice().getAddress()));


    }
}
