package pt.iscte.ipm.mediacenter.remote.events;

import pt.iscte.ipm.mediacenter.playbacksession.PlayBackSessionManager;

import java.net.InetSocketAddress;

public class TextRemoteEvent extends RemoteEvent {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void handle(PlayBackSessionManager playBackSessionManager, InetSocketAddress remoteAddress) {
        System.out.println(text);
        System.out.println(remoteAddress);
    }
}
