package pt.iscte.ipm.mediacenter.utils;

import java.io.*;
import java.util.Properties;

public class SettingsManager {

    private static SettingsManager INSTANCE = null;
    private static final String SETTINGS_FILE = "settings.prop";
    private static Properties props = new Properties();

    private SettingsManager() {
        try {
            props.load(new FileInputStream(SETTINGS_FILE));
        } catch (IOException e) {
            File file = new File(SETTINGS_FILE);
            try {
                file.createNewFile();
                setSetting("port", "80");
                setSetting("movies.dir", "C:\\");
                setSetting("movies.format","/(?<title>.*)/(.*?)\\.(?<ext>.\\w+)$");
                setSetting("series.dir", "C:\\");
                setSetting("series.format","/(?<showName>.*)/Season(?<season>\\d2)/(?<episode>.*)-(?<title>.*)\\.(?<ext>.\\w+)$");
                setSetting("music.dir", "C:\\");
                setSetting("music.format","/(?<artist>.*)/(?<album>.*)/(?<track>.*)-(?<title>.*)\\.(?<ext>.\\w+)$");
                setSetting("mongo.server", "localhost");
                setSetting("mongo.port", "27017");
                setSetting("mongo.user", "root");
                setSetting("mongo.authentication_db", "authentication");
                setSetting("mongo.password", "Iw0ntT3llY0u");
                setSetting("mongo.database", "media_center");
                setSetting("lastfm.api_key", "50dfac108b65a719f19d6086eda1ce9f");
                save();
            } catch (IOException e1) {
                System.err.println("Could not create settings file. Aborting!");
                e1.printStackTrace();
                System.exit(-1);
            }
        }
    }

    public static void save() throws IOException {
        getInstance();
        props.store(new FileOutputStream(SETTINGS_FILE), "");
    }

    public static String getSetting(String key) {
        getInstance();
        return props.getProperty(key);
    }

    public static Integer getIntegerSetting(String key) {
        getInstance();
        return Integer.parseInt(props.getProperty(key));
    }

    public static void setSetting(String key, String value) {
        getInstance();
        props.setProperty(key, value);
    }

    public static SettingsManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SettingsManager();
        }
        return INSTANCE;
    }
}
