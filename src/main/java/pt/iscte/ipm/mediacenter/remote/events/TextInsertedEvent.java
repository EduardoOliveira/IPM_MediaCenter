package pt.iscte.ipm.mediacenter.remote.events;

import pt.iscte.ipm.mediacenter.websocket.events.WebSocketEvent;

public class TextInsertedEvent extends WebSocketEvent {
    private String text;

    public TextInsertedEvent() {
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
