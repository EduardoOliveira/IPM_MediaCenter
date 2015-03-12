package pt.iscte.ipm.mediacenter.websocket.events;

import pt.iscte.ipm.mediacenter.devices.Device;
import pt.iscte.ipm.mediacenter.devices.DeviceManager;

public class ConnectEvent extends WebSocketEvent {
    private DeviceManager deviceManager = DeviceManager.getInstance();
    private String deviceType;
    private String deviceName;

    @Override
    public void handle() {
        if(originDevice==null){
            try {
                Device device = (Device) Class.forName(deviceType).newInstance();
                device.setName(deviceName);
                device.setSession(originSession);
                deviceManager.addDevice(device);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
