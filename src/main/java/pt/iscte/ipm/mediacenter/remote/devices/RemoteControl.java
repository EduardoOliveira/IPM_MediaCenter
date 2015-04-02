package pt.iscte.ipm.mediacenter.remote.devices;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.SlaveDevice;
import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;

import java.util.UUID;

public class RemoteControl extends SlaveDevice {
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();

    public RemoteControl(String deviceName, Session session) {
        super(deviceName, session);
    }

    public RemoteControl(String deviceName, Session session, UUID uuid) {
        super(deviceName, session, uuid);
    }

    @Override
    public void register() {
        slaveDeviceManager.register(this);
    }

    @Override
    public void unregister() {
        slaveDeviceManager.unregister(this);
    }

    @Override
    public void kill() {
        unregister();
        freeDevice();
    }
}
