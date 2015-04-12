package pt.iscte.ipm.mediacenter.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
}
