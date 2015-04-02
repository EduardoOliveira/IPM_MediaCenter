package pt.iscte.ipm.mediacenter.core.devices.managers;

import pt.iscte.ipm.mediacenter.core.devices.Device;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.utils.MultiKeyMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class DeviceManager<T extends Device, K> {

    protected MultiKeyMap<UUID,String,T> devices = new MultiKeyMap<>();

    public T getDeviceByUuid(UUID uuid){
        return devices.get(uuid);
    }

    public T getDeviceByHostName(String hostName){
        return devices.get(hostName);
    }

    public void register(T device) {
        this.devices.put(device.getUuid(),device.getHostName(),device);
    }

    public void unregister(T device) {
        if(device!=null)
            this.devices.remove(device.getUuid());
    }

    public ArrayList<T> getDevices(){
        return new ArrayList<>(devices.values());
    }

    public void broadCast(Event event) {
        for(Device device:devices.values()){
            device.send(event);
        }
    }

    public abstract List<K> pojifyDevices();
}
