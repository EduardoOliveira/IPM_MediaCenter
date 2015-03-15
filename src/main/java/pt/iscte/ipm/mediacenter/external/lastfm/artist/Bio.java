package pt.iscte.ipm.mediacenter.external.lastfm.artist;

public class Bio
{
    private String content;

    private String summary;

    private Formationlist formationlist;

    private String yearformed;

    private String placeformed;

    private Links links;

    private String published;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public Formationlist getFormationlist ()
    {
        return formationlist;
    }

    public void setFormationlist (Formationlist formationlist)
    {
        this.formationlist = formationlist;
    }

    public String getYearformed ()
    {
        return yearformed;
    }

    public void setYearformed (String yearformed)
    {
        this.yearformed = yearformed;
    }

    public String getPlaceformed ()
    {
        return placeformed;
    }

    public void setPlaceformed (String placeformed)
    {
        this.placeformed = placeformed;
    }

    public Links getLinks ()
    {
        return links;
    }

    public void setLinks (Links links)
    {
        this.links = links;
    }

    public String getPublished ()
    {
        return published;
    }

    public void setPublished (String published)
    {
        this.published = published;
    }
}