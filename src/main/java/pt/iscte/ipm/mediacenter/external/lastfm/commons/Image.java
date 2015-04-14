package pt.iscte.ipm.mediacenter.external.lastfm.commons;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
    @JsonProperty("#text")
    private String url;

    private String size;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}