package pt.iscte.ipm.mediacenter.remote.devices;

import pt.iscte.ipm.mediacenter.devices.Device;
import pt.iscte.ipm.mediacenter.devices.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.remote.events.PlayBackDeviceSyncEvent;
import pt.iscte.ipm.mediacenter.websocket.events.EventWrapper;

public class RemoteControl extends Device{
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();

    @Override
    public void register() throws Exception {
        slaveDeviceManager.register(this);
        this.getSession().getRemote().sendString(String.valueOf(new EventWrapper(new PlayBackDeviceSyncEvent())));
    }
}
