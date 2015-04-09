package pt.iscte.ipm.mediacenter.core.database.status;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

/**
 * Created by Admin on 24-02-2015.
 */
@Entity("status")
public enum Status {
    RETURNING, CANCELED, RENEWED, UNDEFINED, NEW, AIRING
}
