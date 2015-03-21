package pt.iscte.ipm.mediacenter.playback.devices;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.Device;
import pt.iscte.ipm.mediacenter.core.devices.managers.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.devices.SlaveDevice;
import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.PlayBackDeviceSyncEvent;
import pt.iscte.ipm.mediacenter.core.sessions.PlayBackSession;

import java.util.ArrayList;
import java.util.List;

public class PlayBackDevice extends Device {
    private PlayBackSession playBackSession;
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
    private List<SlaveDevice> slaves = new ArrayList<>();

    public PlayBackDevice(String name, Session session) {
        super(name, session);
    }

    public void broadCastToAll(Event event) {

        broadCastToSlaves(event);
        send(event);
    }

    public void broadCastToSlaves(Event event) {
        for (SlaveDevice device : slaves) {
            device.send(event);
        }
    }

    @Override
    public void register() {
        playBackDeviceManager.register(this);
    }

    @Override
    public void unregister() {
        playBackDeviceManager.unregister(this);
    }

    @Override
    public void kill() {
        unregister();
        removeAllSlaves();
        SlaveDeviceManager.getInstance().broadCast(new PlayBackDeviceSyncEvent(playBackDeviceManager.pojifyDevices()));
    }

    public String getCurrentlyPlaying() {
        return "Potato";
    }

    public void registerSlave(SlaveDevice device) {
        slaves.add(device);
    }

    public void unregisterSlave(SlaveDevice device) {
        slaves.remove(device);
    }

    public void removeAllSlaves() {
        for (SlaveDevice d : slaves) {
            d.freeDevice();
        }
    }
}
