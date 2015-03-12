package pt.iscte.ipm.mediacenter.devices;

import java.net.InetSocketAddress;
import java.util.HashMap;

public class DeviceManager {

    private static DeviceManager INSTANCE;

    private HashMap<InetSocketAddress,Device> devices = new HashMap<>();

    public Device getDeviceByAddress(InetSocketAddress address){
        return devices.get(address);
    }

    public void removeDevice(Device device){
        devices.remove(device.getSession().getRemoteAddress());
    }

    public static DeviceManager getInstance(){
        if(INSTANCE==null)
            INSTANCE = new DeviceManager();
        return INSTANCE;
    }

    private DeviceManager() {
    }

    public void addDevice(Device device) {
        this.devices.put(device.getSession().getRemoteAddress(),device);
    }
}
