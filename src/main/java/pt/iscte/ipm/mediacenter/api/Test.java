package pt.iscte.ipm.mediacenter.api;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by KnoKer on 02/02/2015.
 */
@Path("/")
public class Test {

    @GET
    @Produces("text/plain")
    public String sayHello(){
        return "Hello";
    }
}
