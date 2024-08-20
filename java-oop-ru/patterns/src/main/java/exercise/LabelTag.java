package exercise;

// BEGIN

public class LabelTag implements TagInterface{

    private TagInterface tag;
    private String value;

    public LabelTag(String value, TagInterface tag) {
        this.tag = tag;
        this.value = value;
    }

    public String render(){
        return "<label>" + value + tag.render() + "</label>";
    }
}

// END
