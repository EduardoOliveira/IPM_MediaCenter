package pt.iscte.ipm.mediacenter.core.transcoder;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamRedirect implements StreamingOutput {


    private InputStream inputStream;

    public StreamRedirect(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void write(OutputStream output) throws IOException, WebApplicationException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            output.write(buffer, 0, len);
        }
    }
}
