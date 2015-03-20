package pt.iscte.ipm.mediacenter.remote.devices;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.Device;
import pt.iscte.ipm.mediacenter.core.devices.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

public class RemoteControl extends Device{
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();
    private PlayBackDevice currentPlayBackDevice;

    public RemoteControl(String deviceName, Session session) {
        super(deviceName,session);
    }

    @Override
    public void register() {
        slaveDeviceManager.register(this);
    }

    public PlayBackDevice getCurrentPlayBackDevice() {
        return currentPlayBackDevice;
    }

    public void registerOnPlaybackDevice(PlayBackDevice playBackDevice) {
        this.currentPlayBackDevice = playBackDevice;
        this.currentPlayBackDevice.registerSlave(this);
    }
}
