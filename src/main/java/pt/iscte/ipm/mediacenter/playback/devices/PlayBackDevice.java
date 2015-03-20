package pt.iscte.ipm.mediacenter.playback.devices;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.Device;
import pt.iscte.ipm.mediacenter.core.devices.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventOutgoingWrapper;
import pt.iscte.ipm.mediacenter.core.sessions.PlayBackSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayBackDevice extends Device {
    private PlayBackSession playBackSession;
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
    private List<Device> slaves = new ArrayList<>();

    public PlayBackDevice() {
    }

    public PlayBackDevice(String name, Session session) {
        super(name, session);
    }

    public void broadCastToAll(Event event) {

        try {
            broadCastToSlaves(event);
            send(String.valueOf(new EventOutgoingWrapper(event)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadCastToSlaves(Event event) {
        for (Iterator<Device> iterator = slaves.iterator(); iterator.hasNext(); ) {

            Device device = iterator.next();
            try {
                device.getSession().getRemote().sendString(String.valueOf(new EventOutgoingWrapper(event)));
            } catch (IOException e) {
                e.printStackTrace();
                iterator.remove();
            }
        }
    }

    @Override
    public void register() {
        playBackDeviceManager.register(this);
    }

    public String getCurrentlyPlaying() {
        return "Potato";
    }

    public void removeSlave(Device device) {
        slaves.remove(device);
    }

    public void registerSlave(Device device) {
        slaves.add(device);
    }
}
