package pt.iscte.ipm.mediacenter.core.devices.managers;

import pt.iscte.ipm.mediacenter.core.devices.SlaveDevice;

import java.util.ArrayList;
import java.util.List;

public class SlaveDeviceManager extends DeviceManager<SlaveDevice, pt.iscte.ipm.mediacenter.pojos.SlaveDevice> {

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

    @Override
    public List<pt.iscte.ipm.mediacenter.pojos.SlaveDevice> pojifyDevices() {
        List<pt.iscte.ipm.mediacenter.pojos.SlaveDevice> rtn = new ArrayList<>();
        pt.iscte.ipm.mediacenter.pojos.SlaveDevice pojo;
        for (SlaveDevice device : devices.values()) {
            pojo = new pt.iscte.ipm.mediacenter.pojos.SlaveDevice();
            pojo.setName(device.getName());
            pojo.setAddress(device.getSession().getRemoteAddress().getHostName());
            if(!device.isFree())pojo.setMasterAddress(device.getMaster().getSession().getRemoteAddress().getHostName());
            rtn.add(pojo);
        }
        return rtn;
    }
}
