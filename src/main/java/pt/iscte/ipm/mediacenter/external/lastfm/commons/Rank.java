package pt.iscte.ipm.mediacenter.external.lastfm.commons;

/**
 * Created by KnoKer on 13/04/2015.
 */
public class Rank {
    private String rank;

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rank = "+rank+"]";
    }
}
