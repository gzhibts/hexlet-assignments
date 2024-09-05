package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{

    private final String body;

    private final List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    public String getBody() {
        return body;
    }

    public List<Tag> getChildren() {
        return children;
    }

    @Override
    public String toString() {

        var attributesString = this.attributesString();

        String result = "<" + this.getName() + attributesString + ">";

        for (var child : children) {
            result = result + child.toString();
        }

        result = result + body + "</" + this.getName() + ">";

        return result;
    }
}
// END
