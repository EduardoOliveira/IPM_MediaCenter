package pt.iscte.ipm.mediacenter.external.lastfm.track;

import pt.iscte.ipm.mediacenter.external.lastfm.commons.Image;

public class Track
{
    private String listeners;

    private String mbid;

    private String name;

    private Image[] image;

    private Streamable streamable;

    private String artist;

    private String url;

    public String getListeners ()
    {
        return listeners;
    }

    public void setListeners (String listeners)
    {
        this.listeners = listeners;
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

    public Image[] getImage ()
    {
        return image;
    }

    public void setImage (Image[] image)
    {
        this.image = image;
    }

    public Streamable getStreamable ()
    {
        return streamable;
    }

    public void setStreamable (Streamable streamable)
    {
        this.streamable = streamable;
    }

    public String getArtist ()
    {
        return artist;
    }

    public void setArtist (String artist)
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
}