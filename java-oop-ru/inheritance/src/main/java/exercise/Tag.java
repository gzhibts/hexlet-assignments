package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String name;
    private final Map<String, String> attributes;

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

    public String attributesString() {
        String attributesString = "";
        var attributesSet = attributes.entrySet();

        for (var el : attributesSet) {
            attributesString = attributesString + " "
                    + el.getKey()
                    + "=\""
                    + el.getValue()
                    + "\"";
        }

        return attributesString;
    }

}

// END
