package pt.iscte.ipm.mediacenter.devices;

import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayBackDeviceManager {

    private static PlayBackDeviceManager INSTANCE;

    private HashMap<InetSocketAddress,PlayBackDevice> devices = new HashMap<>();

    public void register(PlayBackDevice device){
        this.devices.put(device.getSession().getRemoteAddress(),device);
    }

    public void unregister(PlayBackDevice device) {
        this.devices.remove(device.getSession().getRemoteAddress());
    }

    public static PlayBackDeviceManager getInstance(){
        if(INSTANCE==null)
            INSTANCE = new PlayBackDeviceManager();
        return INSTANCE;
    }

    private PlayBackDeviceManager() {
    }

    public PlayBackDevice getDeviceByAddress(InetSocketAddress remoteAddress) {
        return devices.get(remoteAddress);
    }

    public List<PlayBackDevice> getAllPlaybackDevices(){
        return new ArrayList<PlayBackDevice>(devices.values());
    }

    @Override
    public String toString() {
        return "PlayBackDeviceManager{" +
                "devices=" + devices.size() +
                '}';
    }
}
