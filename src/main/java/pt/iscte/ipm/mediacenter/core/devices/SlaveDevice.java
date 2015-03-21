package pt.iscte.ipm.mediacenter.core.devices;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

public abstract class SlaveDevice extends Device {
    private PlayBackDevice master;

    public SlaveDevice(String name, Session session) {
        super(name, session);
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

    public boolean isFree() {
        return this.master == null;
    }
}
