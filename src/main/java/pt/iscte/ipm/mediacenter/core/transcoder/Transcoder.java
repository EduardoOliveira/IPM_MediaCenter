package pt.iscte.ipm.mediacenter.core.transcoder;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Transcoder {

    private Process proc;
    public InputStream transcode(TranscodingProfile transcodingProfile, String input) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        proc = rt.exec(transcodingProfile.getTranscoder() + transcodingProfile.getTrancodingParams());
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader in = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
                String line;

                try {
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return proc.getInputStream();
    }
    
    public void kill(){
        proc.destroy();
    }
}
