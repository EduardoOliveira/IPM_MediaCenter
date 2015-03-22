package pt.iscte.ipm.mediacenter.api;


import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.pojos.SlaveDevice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("devices/slaves")
public class SlaveDevices {

    @GET
    @Produces("application/json")
    public List<SlaveDevice> getAllSlaves(){
        return SlaveDeviceManager.getInstance().pojifyDevices();
    }
}
