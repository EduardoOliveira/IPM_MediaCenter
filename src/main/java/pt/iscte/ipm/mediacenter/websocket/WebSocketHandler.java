package pt.iscte.ipm.mediacenter.websocket;

import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import pt.iscte.ipm.mediacenter.devices.Device;
import pt.iscte.ipm.mediacenter.devices.DeviceManager;
import pt.iscte.ipm.mediacenter.playbacksession.PlayBackSessionManager;
import pt.iscte.ipm.mediacenter.websocket.events.EventWrapper;
import pt.iscte.ipm.mediacenter.websocket.events.WebSocketEvent;

import java.io.IOException;
import java.net.InetSocketAddress;

@WebSocket
public class WebSocketHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    private PlayBackSessionManager playBackSessionManager = new PlayBackSessionManager();
    private DeviceManager deviceManager = DeviceManager.getInstance();

    @OnWebSocketConnect
    public void onConnect(Session session){
        System.out.println("connect");
        try {
            session.getRemote().sendString("qeqe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnWebSocketMessage
    public void onTextMessage(Session session, String text){
        try {
            WebSocketEvent event = objectMapper.readValue(text, EventWrapper.class).getEvent();
            event.setOriginSession(session);
            event.setOriginDevice(deviceManager.getDeviceByAddress(session.getRemoteAddress()));
            event.handle();
            //session.getRemote().sendString(objectMapper.writeValueAsString(new EventWrapper(new KeyPressWebSocketEvent("left"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnWebSocketClose
    public void onClose(Session session, int closeCode, String reason){
        deviceManager.removeDevice(deviceManager.getDeviceByAddress(session.getRemoteAddress()));
    }
}
