package pt.iscte.ipm.mediacenter.external.lastfm.album;

public class AlbumInfo {
    private Album album;

    public Album getAlbum ()
    {
        return album;
    }

    public void setAlbum (Album album)
    {
        this.album = album;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [album = "+album+"]";
    }
}
