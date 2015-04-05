package pt.iscte.ipm.mediacenter.core.settings.pojos;

public class Setting {
    private String label;
    private String id;
    private String value;
    private String description;

    public Setting() {
    }

    public Setting(String label, String id, String value, String description) {
        this.label = label;
        this.id = id;
        this.value = value;
        this.description = description;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "label='" + label + '\'' +
                ", id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
