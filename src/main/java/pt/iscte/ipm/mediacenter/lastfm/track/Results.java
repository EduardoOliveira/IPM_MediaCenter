package pt.iscte.ipm.mediacenter.lastfm.track;


import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

class Results {
    public TrackSearchResult results;

    public class TrackSearchResult {

        @JsonProperty("opensearch:Query")
        public Query query;
        @JsonProperty("opensearch:totalResults")
        public String totalResults;
        @JsonProperty("opensearch:startIndex")
        public String startIndex;
        @JsonProperty("opensearch:itemsPerPage")
        public String itemsPerPage;
        @JsonProperty("trackmatches")
        public TrackMatches trackmatches;

        public class Query {

            @JsonProperty("#text")
            public String text;
            public String role;
            public String searchTerms;
            public String startPage;
        }

        public class TrackMatches {
            public List<Track> track;
        }


    }
}

