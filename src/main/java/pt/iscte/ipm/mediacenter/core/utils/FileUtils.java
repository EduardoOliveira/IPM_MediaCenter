package pt.iscte.ipm.mediacenter.core.utils;

import com.github.kevinsawicki.http.HttpRequest;
import pt.iscte.ipm.mediacenter.core.database.embedded.Image;
import pt.iscte.ipm.mediacenter.core.settings.SettingsManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils {
    public static String DIGEST_SHA1 = "SHA1";
    public static String DIGEST_MD5 = "MD5";

    public static String digest(File f, String algorithm) {
        MessageDigest md = null;
        StringBuffer sb = null;
        try {
            md = MessageDigest.getInstance(algorithm);
            FileInputStream fis = new FileInputStream(f);
            byte[] dataBytes = new byte[1024];

            int nread = 0;

            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }


            byte[] mdbytes = md.digest();

            //convert the byte to hex format
            sb = new StringBuffer("");
            for (byte mdbyte : mdbytes) {
                sb.append(Integer.toString((mdbyte & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return sb != null ? sb.toString() : null;
    }

    public static void downloadFile(String url, String destination) throws IOException {
        HttpRequest request = HttpRequest.get(url);
        File f = new File(destination);
        f.getParentFile().mkdirs();
        f.createNewFile();
        request.receive(f);
    }

    public static String extractExtension(String path) {
        return path.substring(path.lastIndexOf('.') + 1);
    }

    public static String relativizePath(String start, String full) {
        return "." + File.separator + full.substring(start.length());
    }
}
