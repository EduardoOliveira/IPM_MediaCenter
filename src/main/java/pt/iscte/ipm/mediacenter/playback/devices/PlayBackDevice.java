package pt.iscte.ipm.mediacenter.playback.devices;

import pt.iscte.ipm.mediacenter.core.devices.Device;
import pt.iscte.ipm.mediacenter.core.devices.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.sessions.PlayBackSession;

import java.util.ArrayList;
import java.util.List;

public class PlayBackDevice extends Device {

    private PlayBackSession playBackSession;
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
    private List<Device> slaves = new ArrayList<>();

    public void broadCastToAll(Event event) {

 /*       try {
            broadCastToSlaves(event);
            if (this.getSession().getRemoteAddress() != event.getOriginDevice().getSession().getRemoteAddress())
                send(String.valueOf(new EventWrapper(event)));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void broadCastToSlaves(Event event) {
/*        for (Iterator<Device> iterator = slaves.iterator(); iterator.hasNext(); ) {

            Device device = iterator.next();
            try {
                if (device.getSession().getRemoteAddress() != event.getOriginDevice().getSession().getRemoteAddress())
                    device.getSession().getRemote().sendString(String.valueOf(new EventWrapper(event)));
            } catch (IOException e) {
                e.printStackTrace();
                iterator.remove();
            }
        }*/
    }

    @Override
    public void register() {
        playBackDeviceManager.register(this);
    }
}
