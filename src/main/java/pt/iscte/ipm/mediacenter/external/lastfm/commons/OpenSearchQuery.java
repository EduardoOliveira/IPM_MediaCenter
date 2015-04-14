package pt.iscte.ipm.mediacenter.external.lastfm.commons;


import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenSearchQuery {
    private String searchTerms;

    private String role;

    @JsonProperty("#text")
    private String text;

    private String startPage;

    public String getSearchTerms ()
    {
        return searchTerms;
    }

    public void setSearchTerms (String searchTerms)
    {
        this.searchTerms = searchTerms;
    }

    public String getRole ()
    {
        return role;
    }

    public void setRole (String role)
    {
        this.role = role;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getStartPage ()
    {
        return startPage;
    }

    public void setStartPage (String startPage)
    {
        this.startPage = startPage;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [searchTerms = "+searchTerms+", role = "+role+", text = "+ text+", startPage = "+startPage+"]";
    }
}
