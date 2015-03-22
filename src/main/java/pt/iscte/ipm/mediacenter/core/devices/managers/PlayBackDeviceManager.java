package pt.iscte.ipm.mediacenter.core.devices.managers;

import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

import java.util.ArrayList;
import java.util.List;

public class PlayBackDeviceManager extends DeviceManager<PlayBackDevice, pt.iscte.ipm.mediacenter.pojos.PlayBackDevice> {

    private static PlayBackDeviceManager INSTANCE;

    @Override
    public void unregister(PlayBackDevice device) {
        if (device != null) {
            this.devices.remove(device.getSession().getRemoteAddress().getHostName());
        }
    }

    @Override
    public List<pt.iscte.ipm.mediacenter.pojos.PlayBackDevice> pojifyDevices() {
        List<pt.iscte.ipm.mediacenter.pojos.PlayBackDevice> rtn = new ArrayList<>();
        for (PlayBackDevice playBackDevice : devices.values()) {
            rtn.add(new pt.iscte.ipm.mediacenter.pojos.PlayBackDevice(playBackDevice.getName(),
                    playBackDevice.getCurrentlyPlaying().toString(),
                    playBackDevice.getSession().getRemoteAddress().getHostName()));
        }
        return rtn;
    }

    public static PlayBackDeviceManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PlayBackDeviceManager();
        return INSTANCE;
    }

    private PlayBackDeviceManager() {
    }

    @Override
    public String toString() {
        return "PlayBackDeviceManager{" +
                "devices=" + devices.size() +
                '}';
    }

}
