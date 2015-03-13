package pt.iscte.ipm.mediacenter.remote.events;

import pt.iscte.ipm.mediacenter.websocket.events.WebSocketEvent;

public class NavigationEvent extends WebSocketEvent {
    private String keyCode;


    @Override
    public void handle() {
    }


    public NavigationEvent() {
    }

    public NavigationEvent(String keyCode) {
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
        return "NavigationEvent{" +
                "keyCode='" + keyCode + '\'' +
                '}';
    }

}
