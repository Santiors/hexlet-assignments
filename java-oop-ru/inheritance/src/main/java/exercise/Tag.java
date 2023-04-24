package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {
    private String name;
    private Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    protected String attributesToString(Map<String, String> attributes) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=\"");
            sb.append(entry.getValue());
            sb.append("\" ");
        }
        return sb.toString().trim();
    }
}
// END
