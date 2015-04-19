package pt.iscte.ipm.mediacenter.core.database.genre2;

import org.mongodb.morphia.annotations.Entity;

/**
 * Created by Admin on 24-02-2015.
 */
@Entity("genres")
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
