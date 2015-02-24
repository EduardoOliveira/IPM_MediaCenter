package pt.iscte.ipm.mediacenter.database.embedded;

import org.mongodb.morphia.annotations.Embedded;

/**
 * Created by Admin on 24-02-2015.
 */
@Embedded
public enum Status {
    RETURNING, CANCELED, RENEWED, UNDEFINED, NEW, AIRING
}
