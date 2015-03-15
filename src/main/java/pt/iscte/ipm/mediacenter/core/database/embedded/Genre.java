package pt.iscte.ipm.mediacenter.core.database.embedded;

import org.mongodb.morphia.annotations.Embedded;

/**
 * Created by Admin on 24-02-2015.
 */
@Embedded
public enum Genre {
    //Movies / TvShows
    ACTION, ADVENTURE, ANIMATION, BIOGRAPHY, COMEDY, CRIME, DOCUMENTARY, DRAMA,
    FAMILY, FANTASY, FILM_NOIR, HISTORY, HORROR, MUSIC, MUSICAL, MYSTERY, ROMANCE, SCI_FI,
    SPORT, THRILLER, WAR, WESTERN,

    //Music
    ACOUSTIC, AMBIENT, BLUES, CLASSICAL, COUNTRY, ELECTRONIC, EMO, FOLK, HARDCORE,
    HIPHOP, INDIE, JAZZ, LATIN, METAL, POP, POPPUNK, PUNK, REGGAE, RNB, ROCK, SOUL, WORLD, SIXTIES, SEVENTIES,
    EIGHTIES, NINETIES //Taken from http://www.lastfm.com.br/music
}
