package pt.iscte.ipm.mediacenter.external.lastfm.album;

import com.fasterxml.jackson.annotation.JsonProperty;
import pt.iscte.ipm.mediacenter.external.lastfm.commons.Attr;
import pt.iscte.ipm.mediacenter.external.lastfm.commons.Rank;
import pt.iscte.ipm.mediacenter.external.lastfm.commons.Streamable;

public class Track {
    private String duration;

    private String mbid;

    private String name;

    private Streamable streamable;

    private Artist artist;

    private String url;

    @JsonProperty("@attr")
    private Rank attr;

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getMbid ()
    {
        return mbid;
    }

    public void setMbid (String mbid)
    {
        this.mbid = mbid;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Streamable getStreamable ()
    {
        return streamable;
    }

    public void setStreamable (Streamable streamable)
    {
        this.streamable = streamable;
    }

    public Artist getArtist ()
    {
        return artist;
    }

    public void setArtist (Artist artist)
    {
        this.artist = artist;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public Rank getAttr() {
        return attr;
    }

    public void setAttr(Rank attr) {
        this.attr = attr;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [duration = "+duration+", mbid = "+mbid+", name = "+name+", streamable = "+streamable+", artist = "+artist+", url = "+url+"]";
    }

}
