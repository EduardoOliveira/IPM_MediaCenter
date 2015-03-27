package pt.iscte.ipm.mediacenter.api;


import pt.iscte.ipm.mediacenter.core.devices.managers.PlayBackDeviceManager;
import pt.iscte.ipm.mediacenter.core.devices.managers.SlaveDeviceManager;
import pt.iscte.ipm.mediacenter.playback.devices.PlayBackDevice;
import pt.iscte.ipm.mediacenter.pojos.SlaveDevice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("devices/{master}/slaves")
public class MasterSlaveDevices {
    PlayBackDeviceManager playBackDeviceManager = PlayBackDeviceManager.getInstance();
    SlaveDeviceManager slaveDeviceManager = SlaveDeviceManager.getInstance();

    @GET
    @Produces("application/json")
    public List<SlaveDevice> getAllSlaves(@PathParam("master") String master) {
        if (master == null) return new ArrayList<>();
        return playBackDeviceManager.getDeviceByHostName(master).pojifySlaves();
    }

    @GET
    @Produces("applications/json")
    @Path("disconnect/{slave}")
    public String disconnect(@PathParam("master") String master, @PathParam("slave") String slave) {
        slaveDeviceManager.getDeviceByHostName(slave).freeDevice();
        return "ok";
    }
}
