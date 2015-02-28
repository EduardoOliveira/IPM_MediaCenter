package pt.iscte.ipm.mediacenter.lastfm.commons;

import org.codehaus.jackson.annotate.JsonProperty;

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
