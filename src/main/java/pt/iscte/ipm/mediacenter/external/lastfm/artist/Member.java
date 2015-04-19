package pt.iscte.ipm.mediacenter.external.lastfm.artist;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member
{
    @JsonProperty("yearto")
    private String yearTo;

    private String name;

    @JsonProperty("yearfrom")
    private String yearFrom;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getYearFrom()
    {
        return yearFrom;
    }

    public void setYearFrom(String yearFrom)
    {
        this.yearFrom = yearFrom;
    }

    public String getYearTo() {
        return yearTo;
    }

    public void setYearTo(String yearTo) {
        this.yearTo = yearTo;
    }
}