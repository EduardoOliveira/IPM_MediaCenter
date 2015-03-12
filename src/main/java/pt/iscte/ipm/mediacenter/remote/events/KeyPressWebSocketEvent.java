package pt.iscte.ipm.mediacenter.remote.events;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.websocket.events.WebSocketEvent;

import java.net.InetSocketAddress;

public class KeyPressWebSocketEvent extends WebSocketEvent {
    private String keyCode;

    public KeyPressWebSocketEvent() {
    }

    public KeyPressWebSocketEvent(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }


    @Override
    public String toString() {
        return "KeyPressWebSocketEvent{" +
                "keyCode='" + keyCode + '\'' +
                '}';
    }

    @Override
    public void handle() {
        System.out.println(this);
        System.out.println(this.originSession.getRemoteAddress());
    }
}
