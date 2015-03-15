package pt.iscte.ipm.mediacenter.remote.devices;

import pt.iscte.ipm.mediacenter.core.devices.Device;
import pt.iscte.ipm.mediacenter.core.devices.SlaveDeviceManager;

public class RemoteControl extends Device{
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();

    @Override
    public void register() throws Exception {
        slaveDeviceManager.register(this);
        //this.getSession().getRemote().sendString(String.valueOf(new EventWrapper(new PlayBackDeviceSyncEvent())));
    }
}
