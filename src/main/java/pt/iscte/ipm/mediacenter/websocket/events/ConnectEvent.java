package pt.iscte.ipm.mediacenter.websocket.events;

import pt.iscte.ipm.mediacenter.devices.Device;
import pt.iscte.ipm.mediacenter.devices.SlaveDeviceManager;

import java.io.IOException;

public class ConnectEvent extends WebSocketEvent {
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();
    private String deviceType;
    private String deviceName;

    @Override
    public void handle() throws Exception {
        if(originDevice==null){
                Device device = (Device) Class.forName(deviceType).newInstance();
                device.setName(deviceName);
                device.setSession(originSession);
                device.register();
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
