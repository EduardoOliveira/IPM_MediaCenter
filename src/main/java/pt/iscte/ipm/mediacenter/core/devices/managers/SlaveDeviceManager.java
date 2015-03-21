package pt.iscte.ipm.mediacenter.core.devices.managers;

import pt.iscte.ipm.mediacenter.core.devices.Device;

public class SlaveDeviceManager extends DeviceManager<Device> {

    private static SlaveDeviceManager INSTANCE;


    public static SlaveDeviceManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SlaveDeviceManager();
        return INSTANCE;
    }

    private SlaveDeviceManager() {
    }

    @Override
    public String toString() {
        return "SlaveDeviceManager{" +
                "devices=" + devices.size() +
                '}';
    }
}
