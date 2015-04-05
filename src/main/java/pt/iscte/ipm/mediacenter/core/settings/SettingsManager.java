package pt.iscte.ipm.mediacenter.core.settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import pt.iscte.ipm.mediacenter.core.settings.pojos.Group;
import pt.iscte.ipm.mediacenter.core.settings.pojos.Setting;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class SettingsManager {
    private static ObjectMapper mapper = new ObjectMapper();
    private static SettingsManager INSTANCE = null;
    private static final String SETTINGS_FOLDER = "settings/";
    private static HashMap<String,Group> groups = new HashMap<>();
    //private static Properties props = new Properties();

    private SettingsManager() {
        File folder = new File(SETTINGS_FOLDER);
        File[] listOfFiles = folder.listFiles();

        for (File f : listOfFiles) {
            try {
                Group group = (Group)mapper.readValue(f, Group.class);
                groups.put(group.getId(),group);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void save() throws IOException {
        getInstance();
        for(Group g : groups.values()){
            mapper.writeValue(new File(SETTINGS_FOLDER+g.getId()+".json"), g);
        }
    }

    public static String getSetting(String group,String key) {
        getInstance();
        return groups.get(group).getSetting(key).getValue();
    }

    public static Integer getIntegerSetting(String group,String key) {
        getInstance();
        return Integer.parseInt(groups.get(group).getSetting(key).getValue());
    }

    public static void setSetting(String group,String key, String value) {
        getInstance();
        groups.get(group).getSetting(key).setValue(value);
    }

    public static SettingsManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SettingsManager();
        }
        return INSTANCE;
    }

    public static List<Group> pojify() {
        return new ArrayList<>(groups.values());
    }

    public static void setGroup(Group group) {
        groups.put(group.getId(),group);
    }
}
