package pt.iscte.ipm.mediacenter.remote.events;

import pt.iscte.ipm.mediacenter.playbacksession.PlayBackSessionManager;

import java.net.InetSocketAddress;

public abstract class RemoteEvent {

    public abstract void handle(PlayBackSessionManager playBackSessionManager,InetSocketAddress remoteAddress);

}
