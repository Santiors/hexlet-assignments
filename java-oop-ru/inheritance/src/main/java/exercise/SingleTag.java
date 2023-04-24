package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
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
        return sb.toString();
    }
}
// END
