package pt.iscte.ipm.mediacenter.external.lastfm.artist;

public class BandMembers {
    private Member[] member;

    public Member[] getMember ()
    {
        return member;
    }

    public void setMember (Member[] member)
    {
        this.member = member;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [member = "+member+"]";
    }
}
