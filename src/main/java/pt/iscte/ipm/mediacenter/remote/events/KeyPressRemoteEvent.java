package pt.iscte.ipm.mediacenter.remote.events;

import pt.iscte.ipm.mediacenter.playbacksession.PlayBackSessionManager;

import java.net.InetSocketAddress;

public class KeyPressRemoteEvent extends RemoteEvent {
    private String keyCode;

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }


    @Override
    public String toString() {
        return "KeyPressRemoteEvent{" +
                "keyCode='" + keyCode + '\'' +
                '}';
    }

    @Override
    public void handle(PlayBackSessionManager playBackSessionManager, InetSocketAddress remoteAddress) {
        System.out.println(this);
        System.out.println(remoteAddress);
    }
}
