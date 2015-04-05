package pt.iscte.ipm.mediacenter.api;

import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;
import pt.iscte.ipm.mediacenter.core.settings.pojos.Group;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("settings")
public class Settings {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Group> getSettings(){
        return SettingsManager.pojify();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveGroup(Group group){
        SettingsManager.setGroup(group);
        try {
            SettingsManager.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
