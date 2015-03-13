package pt.iscte.ipm.mediacenter.websocket;

import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import pt.iscte.ipm.mediacenter.devices.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.devices.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.websocket.events.EventWrapper;
import pt.iscte.ipm.mediacenter.websocket.events.WebSocketEvent;

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
            WebSocketEvent event = objectMapper.readValue(text, EventWrapper.class).getEvent();
            event.setOriginSession(session);
            event.setOriginDevice(playBackDeviceManager.getDeviceByAddress(session.getRemoteAddress()));
            if (event.getOriginDevice() == null)
                event.setOriginDevice(slaveDeviceManager.getDeviceByAddress(session.getRemoteAddress()));
            event.handle();
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
