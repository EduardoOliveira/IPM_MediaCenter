package pt.iscte.ipm.mediacenter.external.lastfm.commons;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Attr {

    @JsonProperty("for")
    private String target;

    public String getTarget ()
    {
        return target;
    }

    public void setFor (String target)
    {
        this.target = target;
    }
}
