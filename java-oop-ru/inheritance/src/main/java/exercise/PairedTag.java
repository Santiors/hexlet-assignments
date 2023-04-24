package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getName());
        if (!getAttributes().isEmpty()) {
            sb.append(" ");
            sb.append(attributesToString(getAttributes()));
        }
        sb.append(">");
        if (!body.isEmpty()) {
            sb.append(body);
        } else if (!children.isEmpty()) {
            for (Tag child : children) {
                sb.append(child.toString());
            }
        }
        sb.append("</");
        sb.append(getName());
        sb.append(">");
        return sb.toString();
    }
}
// END
