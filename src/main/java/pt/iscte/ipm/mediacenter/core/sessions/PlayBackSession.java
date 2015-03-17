package pt.iscte.ipm.mediacenter.core.sessions;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.core.devices.Device;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventOutgoingWrapper;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PlayBackSession {

    private List<Device> devices = new LinkedList<>();
    private PlayBackDevice playBackDevice;

    public PlayBackSession(PlayBackDevice playBackDevice) {
        this.playBackDevice = playBackDevice;
    }

    public String getSessionName() {
        return playBackDevice.getName();
    }

    public void broadCastToAll(Event event, Session origin){

    }

    public void broadCastToAll(Event event) {
        for (Iterator<Device> iterator = devices.iterator(); iterator.hasNext(); ) {

            Device device = iterator.next();
            try {
                device.getSession().getRemote().sendString(String.valueOf(new EventOutgoingWrapper(event)));
            } catch (IOException e) {
                e.printStackTrace();
                iterator.remove();
            }
        }
        sendToPlayBackDevice(event);
    }

    public void sendToPlayBackDevice(Event event) {
        try {
            playBackDevice.getSession().getRemote().sendString(String.valueOf(new EventOutgoingWrapper(event)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

