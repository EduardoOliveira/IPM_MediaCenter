package pt.iscte.ipm.mediacenter.playback.devices;

import pt.iscte.ipm.mediacenter.devices.Device;
import pt.iscte.ipm.mediacenter.devices.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.sessions.PlayBackSession;
import pt.iscte.ipm.mediacenter.websocket.events.EventWrapper;
import pt.iscte.ipm.mediacenter.websocket.events.WebSocketEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayBackDevice extends Device {

    private PlayBackSession playBackSession;
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
    private List<Device> slaves = new ArrayList<>();

    public void broadCastToAll(WebSocketEvent event) {

        try {
            broadCastToSlaves(event);
            if (this.getSession().getRemoteAddress() != event.getOriginDevice().getSession().getRemoteAddress())
                send(String.valueOf(new EventWrapper(event)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadCastToSlaves(WebSocketEvent event) {
        for (Iterator<Device> iterator = slaves.iterator(); iterator.hasNext(); ) {

            Device device = iterator.next();
            try {
                if (device.getSession().getRemoteAddress() != event.getOriginDevice().getSession().getRemoteAddress())
                    device.getSession().getRemote().sendString(String.valueOf(new EventWrapper(event)));
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
}
