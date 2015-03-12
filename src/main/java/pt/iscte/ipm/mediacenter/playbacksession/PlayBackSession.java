package pt.iscte.ipm.mediacenter.playbacksession;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.playbacksession.devices.PlayBackDevice;
import pt.iscte.ipm.mediacenter.devices.Device;
import pt.iscte.ipm.mediacenter.websocket.events.EventWrapper;
import pt.iscte.ipm.mediacenter.websocket.events.WebSocketEvent;

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

    public void broadCastToAll(WebSocketEvent event, Session origin){

    }

    public void broadCastToAll(WebSocketEvent event) {
        for (Iterator<Device> iterator = devices.iterator(); iterator.hasNext(); ) {

            Device device = iterator.next();
            try {
                device.getSession().getRemote().sendString(String.valueOf(new EventWrapper(event)));
            } catch (IOException e) {
                e.printStackTrace();
                iterator.remove();
            }
        }
        sendToPlayBackDevice(event);
    }

    public void sendToPlayBackDevice(WebSocketEvent event) {
        try {
            playBackDevice.getSession().getRemote().sendString(String.valueOf(new EventWrapper(event)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

