package pt.iscte.ipm.mediacenter.lastfm.track;


import org.codehaus.jackson.annotate.JsonProperty;
import pt.iscte.ipm.mediacenter.lastfm.commons.Attr;
import pt.iscte.ipm.mediacenter.lastfm.commons.OpenSearchQuery;

public class Results
{

    private Trackmatches trackmatches;

    @JsonProperty("opensearch:Query")
    private OpenSearchQuery openSearchQuery;

    @JsonProperty("opensearch:totalResults")
    private Long totalResults;

    @JsonProperty("opensearch:startIndex")
    private Long startIndex;

    @JsonProperty("opensearch:itemsPerPage")
    private Long itemPerPage;

    @JsonProperty("@attr")
    private Attr attr;

    public Trackmatches getTrackmatches ()
    {
        return trackmatches;
    }

    public void setTrackmatches (Trackmatches trackmatches)
    {
        this.trackmatches = trackmatches;
    }

    public OpenSearchQuery getOpenSearchQuery() {
        return openSearchQuery;
    }

    public void setOpenSearchQuery(OpenSearchQuery openSearchQuery) {
        this.openSearchQuery = openSearchQuery;
    }

    public Long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Long startIndex) {
        this.startIndex = startIndex;
    }

    public Long getItemPerPage() {
        return itemPerPage;
    }

    public void setItemPerPage(Long itemPerPage) {
        this.itemPerPage = itemPerPage;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }
}
