package pt.iscte.ipm.mediacenter.api;

import pt.iscte.ipm.mediacenter.core.transcoder.StreamRedirect;
import pt.iscte.ipm.mediacenter.core.transcoder.Transcoder;
import pt.iscte.ipm.mediacenter.core.transcoder.TranscodingProfile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/play")
public class Playback {

    @GET
    @Path("{show}/{season}/{episode}")
    @Produces("video/ogg")
    public Response playTvShow(@PathParam("show") String show,
                           @PathParam("season") int season,
                           @PathParam("episode") int episode) {
        StreamRedirect sr = null;
        try {
             sr = new StreamRedirect(new Transcoder().transcode(
                    new TranscodingProfile(TranscodingProfile.TranscodeType.SHOW), ""));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return Response.ok(sr).build();
    }
}
