package pt.iscte.ipm.mediacenter.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import pt.iscte.ipm.mediacenter.core.devices.Device;
import pt.iscte.ipm.mediacenter.core.devices.managers.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.core.events.EventHandler;
import pt.iscte.ipm.mediacenter.core.events.EventIncomingWrapper;
import pt.iscte.ipm.mediacenter.core.events.Ping;

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
            EventIncomingWrapper eventWrapper = objectMapper.readValue(text, EventIncomingWrapper.class);
            Event event = eventWrapper.getData();
            if(!Ping.class.isInstance(event))
                System.out.println("receiving: " + text);
            EventHandler eventHandler = (EventHandler) Class.forName(event.getHandler()).newInstance();
            eventHandler.handle(event, session);
        } catch (Exception e) {
            e.printStackTrace();
            removeDevice(session.getRemoteAddress().getHostName());
        }
    }

    private void removeDevice(String hostName) {
        Device device = playBackDeviceManager.getDeviceByHostName(hostName);
        if (device != null) device.kill();

        device = slaveDeviceManager.getDeviceByHostName(hostName);
        if (device != null) device.kill();
    }

    @OnWebSocketClose
    public void onClose(Session session, int closeCode, String reason) {
        removeDevice(session.getRemoteAddress().getHostName());
    }
}
