package pt.iscte.ipm.mediacenter.core.devices.managers;

import pt.iscte.ipm.mediacenter.core.devices.Device;
import pt.iscte.ipm.mediacenter.core.events.Event;

import java.util.ArrayList;
import java.util.HashMap;

public class DeviceManager<T extends Device> {

    protected HashMap<String,T> devices = new HashMap<>();

    public T getDeviceByHostName(String address){
        return devices.get(address);
    }

    public void register(T device) {
        this.devices.put(device.getSession().getRemoteAddress().getHostName(),device);
    }

    public void unregister(T device) {
        if(device!=null)
            this.devices.remove(device.getSession().getRemoteAddress().getHostName());
    }

    public ArrayList<T> getDevices(){
        return new ArrayList<>(devices.values());
    }

    public void broadCast(Event event) {
        for(Device device:devices.values()){
            device.send(event);
        }
    }
}
