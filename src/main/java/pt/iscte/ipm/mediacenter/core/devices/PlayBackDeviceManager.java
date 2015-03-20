package pt.iscte.ipm.mediacenter.core.devices;

import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayBackDeviceManager {

    private static PlayBackDeviceManager INSTANCE;

    private HashMap<String,PlayBackDevice> devices = new HashMap<>();

    public void register(PlayBackDevice device){
        this.devices.put(device.getSession().getRemoteAddress().getHostName(),device);
    }

    public void unregister(PlayBackDevice device) {
        if(device!=null)this.devices.remove(device.getSession().getRemoteAddress().getHostName());
    }

    public static PlayBackDeviceManager getInstance(){
        if(INSTANCE==null)
            INSTANCE = new PlayBackDeviceManager();
        return INSTANCE;
    }

    private PlayBackDeviceManager() {
    }

    public PlayBackDevice getDeviceByAddress(String hostName) {
        return devices.get(hostName);
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

    public List<pt.iscte.ipm.mediacenter.pojos.PlayBackDevice> pojifyDevices() {
        List<pt.iscte.ipm.mediacenter.pojos.PlayBackDevice> rtn = new ArrayList<>();
        for(PlayBackDevice playBackDevice : devices.values()){
            rtn.add(new pt.iscte.ipm.mediacenter.pojos.PlayBackDevice(playBackDevice.getName(),
                    playBackDevice.getCurrentlyPlaying().toString(),
                    playBackDevice.getSession().getRemoteAddress().getHostName()));
        }
        return rtn;
    }
}
