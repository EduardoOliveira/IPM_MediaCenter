package pt.iscte.ipm.mediacenter.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import pt.iscte.ipm.mediacenter.core.devices.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.devices.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.core.events.EventIncomingWrapper;
import pt.iscte.ipm.mediacenter.core.events.EventOutgoingWrapper;
import pt.iscte.ipm.mediacenter.events.remote.NavigationEvent;

import java.net.InetSocketAddress;

@WebSocket
public class WebSocketHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    private SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();
    private PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.println("connect:" + session.getRemoteAddress());
    }

    @OnWebSocketMessage
    public void onTextMessage(Session session, String text) {
        try {
            System.out.println(text);
            EventIncomingWrapper eventWrapper = objectMapper.readValue(text, EventIncomingWrapper.class);
            Event event = eventWrapper.getData();
            EventHandler eventHandler = (EventHandler) Class.forName(event.getHandler()).newInstance();
            eventHandler.handle(event,session);
        } catch (Exception e) {
            e.printStackTrace();
            removeDevice(session.getRemoteAddress());
        }
    }

    private void removeDevice(InetSocketAddress remoteAddress) {
        playBackDeviceManager.unregister(playBackDeviceManager.getDeviceByAddress(remoteAddress));
        slaveDeviceManager.unregister(slaveDeviceManager.getDeviceByAddress(remoteAddress));
    }

    @OnWebSocketClose
    public void onClose(Session session, int closeCode, String reason) {
        removeDevice(session.getRemoteAddress());
    }
}
