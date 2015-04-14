package pt.iscte.ipm.mediacenter.external.lastfm.album;

public class Artist {

    private String mbid;

    private String name;

    private String url;

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
        return "ClassPojo [mbid = "+mbid+", name = "+name+", url = "+url+"]";
    }
}
