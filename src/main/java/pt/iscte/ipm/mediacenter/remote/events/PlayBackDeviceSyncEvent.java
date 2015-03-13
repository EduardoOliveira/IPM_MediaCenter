package pt.iscte.ipm.mediacenter.remote.events;

import pt.iscte.ipm.mediacenter.devices.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;
import pt.iscte.ipm.mediacenter.websocket.events.WebSocketEvent;

import java.util.Collection;
import java.util.List;

public class PlayBackDeviceSyncEvent extends WebSocketEvent {
    private List<PlayBackDevice> playBackDevices;

    public PlayBackDeviceSyncEvent() {
        this.playBackDevices = PlayBackDeviceManager.getInstance().getAllPlaybackDevices();
    }

    public List<PlayBackDevice> getPlayBackDevices() {
        return playBackDevices;
    }

    @Override
    public void handle() {
        throw new UnsupportedOperationException("Unimplemented Method");
    }
}
