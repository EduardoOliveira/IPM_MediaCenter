package pt.iscte.ipm.mediacenter.external.lastfm.album;

public class Tracks {
    private Track[] track;

    public Track[] getTrack ()
    {
        return track;
    }

    public void setTrack (Track[] track)
    {
        this.track = track;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [track = "+track+"]";
    }
}
