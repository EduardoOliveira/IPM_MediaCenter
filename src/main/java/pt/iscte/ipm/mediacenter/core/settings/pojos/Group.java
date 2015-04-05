package pt.iscte.ipm.mediacenter.core.settings.pojos;

import java.util.List;

public class Group {
    private String label;
    private String id;
    private String description;
    private List<Setting> settings;

    public Group() {
    }

    public Group(String label, String id, String description, List<Setting> settings) {
        this.label = label;
        this.id = id;
        this.description = description;
        this.settings = settings;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    public Setting getSetting(String id) {
        for (Setting s : settings) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }

    @Override
    public String toString() {
        String rtn = "Group{" +
                "label='" + label + '\'' +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", settings=[";
        for (Setting s : settings) {
            rtn += s.toString() + ", ";
        }
        rtn += "]}";
        return rtn;
    }
}
