package pt.iscte.ipm.mediacenter.core.devices;

import java.net.InetSocketAddress;
import java.util.HashMap;

public class SlaveDeviceManager {

    private static SlaveDeviceManager INSTANCE;

    private HashMap<String,Device> devices = new HashMap<>();

    public Device getDeviceByHostName(String address){
        return devices.get(address);
    }

    public static SlaveDeviceManager getInstance(){
        if(INSTANCE==null)
            INSTANCE = new SlaveDeviceManager();
        return INSTANCE;
    }

    private SlaveDeviceManager() {
    }

    public void register(Device device) {
        this.devices.put(device.getSession().getRemoteAddress().getHostName(),device);
    }

    public void unregister(Device device) {
        if(device!=null)
            this.devices.remove(device.getSession().getRemoteAddress().getHostName());
    }

    @Override
    public String toString() {
        return "SlaveDeviceManager{" +
                "devices=" + devices.size() +
                '}';
    }
}
