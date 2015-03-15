package pt.iscte.ipm.mediacenter.core.sessions;

import java.util.ArrayList;
import java.util.List;

public class PlayBackSessionManager {
    private static PlayBackSessionManager INSTANCE;
    private List<PlayBackSession> playBackSessions = new ArrayList<>();

    //get a playback session


    public static PlayBackSessionManager getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PlayBackSessionManager();
        return INSTANCE;
    }

    private PlayBackSessionManager() {
    }
}
