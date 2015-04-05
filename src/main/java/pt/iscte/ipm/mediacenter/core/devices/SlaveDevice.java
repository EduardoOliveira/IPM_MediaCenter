package pt.iscte.ipm.mediacenter.core.devices;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.events.DisconnectedFromPlayBackDeviceSyncEvent;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

import java.util.UUID;

public abstract class SlaveDevice extends Device {
    private PlayBackDevice master;

    public SlaveDevice(String name, Session session) {
        super(name, session);
    }

    public SlaveDevice(String deviceName, Session session, UUID uuid) {
        super(deviceName, session, uuid);
    }

    public PlayBackDevice getMaster() {
        return master;
    }

    public void setMaster(PlayBackDevice master) {
        if (master != null) {
            this.master = master;
            this.master.registerSlave(this);
        }
    }

    public void freeDevice() {
        if (!isFree()) {
            this.master.unregisterSlave(this);
            this.master = null;
        }
    }

    public void freeDevice(int code) {
        if (!isFree()) {
            send(new DisconnectedFromPlayBackDeviceSyncEvent(code, master.getUuid().toString()));
            freeDevice();
        }
    }

    public boolean isFree() {
        return this.master == null;
    }
}
