package pt.iscte.ipm.mediacenter.external.lastfm.artist;

import org.codehaus.jackson.annotate.JsonProperty;

public class Link {

    @JsonProperty("#text")
    private String text;

    private String rel;

    private String href;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}