package pt.iscte.ipm.mediacenter.external.lastfm.track;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Streamable {
    private String fulltrack;

    @JsonProperty("#text")
    private String text;

    public String getFulltrack() {
        return fulltrack;
    }

    public void setFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}