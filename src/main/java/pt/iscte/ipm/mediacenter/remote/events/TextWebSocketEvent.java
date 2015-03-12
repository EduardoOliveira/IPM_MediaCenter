package pt.iscte.ipm.mediacenter.remote.events;

import org.eclipse.jetty.websocket.api.Session;
import pt.iscte.ipm.mediacenter.websocket.events.WebSocketEvent;

public class TextWebSocketEvent extends WebSocketEvent {
    private String text;

    public TextWebSocketEvent() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void handle() {
        System.out.println(text);
        System.out.println(originSession.getRemoteAddress());
    }
}
