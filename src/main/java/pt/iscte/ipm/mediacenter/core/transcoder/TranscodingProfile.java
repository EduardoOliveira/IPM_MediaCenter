package pt.iscte.ipm.mediacenter.core.transcoder;

import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

public class TranscodingProfile {
    private final String transcoder;
    private final String trancodingParams;

    private final TranscodeType type;

    public enum TranscodeType {
        MOVIE, SHOW, MUSIC
    }

    public TranscodingProfile(TranscodeType type) {
        this.type = type;
        this.transcoder = SettingsManager.getSetting("transcoding", "transcoder");
        this.trancodingParams = SettingsManager.getSetting("transcoding", type.toString());
    }

    public String getTranscoder() {
        return transcoder;
    }

    public String getTrancodingParams() {
        return trancodingParams;
    }

    public TranscodeType getType() {
        return type;
    }
}
