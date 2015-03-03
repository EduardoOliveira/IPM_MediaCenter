package pt.iscte.ipm.mediacenter.remote.websocket;

import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import pt.iscte.ipm.mediacenter.playbacksession.PlayBackSessionManager;
import pt.iscte.ipm.mediacenter.remote.events.EventWrapper;

import java.io.IOException;
import java.net.InetSocketAddress;

@WebSocket
public class WebSocketHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    private PlayBackSessionManager playBackSessionManager = new PlayBackSessionManager();

    @OnWebSocketConnect
    public void onConnect(Session session){
        try {
            session.getRemote().sendString("qeqe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnWebSocketMessage
    public void onTextMessage(Session session, String text){
        InetSocketAddress remoteAddress = session.getRemoteAddress();
        try {
            objectMapper.readValue(text, EventWrapper.class)
                    .getRemoteEvent().handle(playBackSessionManager,session.getRemoteAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnWebSocketClose
    public void onClose(Session session, int closeCode, String reason){

    }
}
