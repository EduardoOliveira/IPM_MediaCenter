package pt.iscte.ipm.mediacenter.events.remote;

import pt.iscte.ipm.mediacenter.core.events.Event;

public class NavigationEvent extends Event {
    private String keyCode;

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
