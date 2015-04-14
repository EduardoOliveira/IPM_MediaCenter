package pt.iscte.ipm.mediacenter.external.lastfm.commons;

/**
 * Created by KnoKer on 13/04/2015.
 */
public class Wiki {

    private String content;

    private String summary;

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

    public String getPublished ()
    {
        return published;
    }

    public void setPublished (String published)
    {
        this.published = published;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", summary = "+summary+", published = "+published+"]";
    }

}
