package pt.iscte.ipm.mediacenter.external.lastfm.artist;

import org.codehaus.jackson.annotate.JsonProperty;
import pt.iscte.ipm.mediacenter.external.lastfm.commons.Image;

public class Artist{

    @JsonProperty("artist")
    public ArtistInfo artistInfo;

    public class ArtistInfo
    {
        private Tags tags;

        private String ontour;

        private String mbid;

        private Bio bio;

        private Stats stats;

        private String name;

        private String streamable;

        private Image[] image;


        @JsonProperty("bandmembers")
        private BandMembers bandMembers;

        private String url;

        private Similar similar;

        public Tags getTags ()
        {
            return tags;
        }

        public void setTags (Tags tags)
        {
            this.tags = tags;
        }

        public String getOntour ()
        {
            return ontour;
        }

        public void setOntour (String ontour)
        {
            this.ontour = ontour;
        }

        public String getMbid ()
        {
            return mbid;
        }

        public void setMbid (String mbid)
        {
            this.mbid = mbid;
        }

        public Bio getBio ()
        {
            return bio;
        }

        public void setBio (Bio bio)
        {
            this.bio = bio;
        }

        public Stats getStats ()
        {
            return stats;
        }

        public void setStats (Stats stats)
        {
            this.stats = stats;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getStreamable ()
        {
            return streamable;
        }

        public void setStreamable (String streamable)
        {
            this.streamable = streamable;
        }

        public Image[] getImage ()
        {
            return image;
        }

        public void setImage (Image[] image)
        {
            this.image = image;
        }

        public BandMembers getBandMembers()
        {
            return bandMembers;
        }

        public void setBandMembers(BandMembers bandMembers)
        {
            this.bandMembers = bandMembers;
        }

        public String getUrl ()
        {
            return url;
        }

        public void setUrl (String url)
        {
            this.url = url;
        }

        public Similar getSimilar ()
        {
            return similar;
        }

        public void setSimilar (Similar similar)
        {
            this.similar = similar;
        }
    }

}