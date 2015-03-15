package pt.iscte.ipm.mediacenter.core.events;


import pt.iscte.ipm.mediacenter.pojos.PlayBackDevice;

import java.util.List;

public class PlayBackDeviceSyncEvent extends Event {
    private List<PlayBackDevice> playBackDevices;

    public List<PlayBackDevice> getPlayBackDevices() {
        return playBackDevices;
    }

    public void setPlayBackDevices(List<PlayBackDevice> playBackDevices) {
        this.playBackDevices = playBackDevices;
    }
}
