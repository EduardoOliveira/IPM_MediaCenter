package pt.iscte.ipm.mediacenter.external.lastfm.album;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pt.iscte.ipm.mediacenter.external.lastfm.commons.Image;
import pt.iscte.ipm.mediacenter.external.lastfm.commons.Wiki;

@JsonIgnoreProperties("toptags")
public class Album {
    private String id;

    private String listeners;

    private String mbid;

    private String name;

    @JsonProperty("image")
    private Image[] images;

    private String playcount;

    @JsonProperty("releasedate")
    private String releaseDate;

    private Tracks tracks;

    private String artist;

    private Wiki wiki;

    private String url;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

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

    public Image[] getImages ()
    {
        return images;
    }

    public void setImages (Image[] images)
    {
        this.images = images;
    }

    public String getPlaycount ()
    {
        return playcount;
    }

    public void setPlaycount (String playcount)
    {
        this.playcount = playcount;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public Tracks getTracks ()
    {
        return tracks;
    }

    public void setTracks (Tracks tracks)
    {
        this.tracks = tracks;
    }

    public String getArtist ()
    {
        return artist;
    }

    public void setArtist (String artist)
    {
        this.artist = artist;
    }

    public Wiki getWiki ()
    {
        return wiki;
    }

    public void setWiki (Wiki wiki)
    {
        this.wiki = wiki;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", listeners = "+listeners+", mbid = "+mbid+", name = "+name+", image = "+images+", playcount = "+playcount+", releaseDate = "+ releaseDate +", tracks = "+tracks+", artist = "+artist+", wiki = "+wiki+", url = "+url+"]";
    }
}
