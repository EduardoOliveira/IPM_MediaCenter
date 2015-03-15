package pt.iscte.ipm.mediacenter.external.lastfm.artist;

import pt.iscte.ipm.mediacenter.external.lastfm.commons.Image;

public class SimilarArtist
{
    private String name;

    private Image[] image;

    private String url;

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

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }
}