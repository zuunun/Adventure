import java.util.ArrayList;

public class Item {
    private String longName;
    private String shortName;

    public Item( String shortName,String longName) {
        this.longName = longName;
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }

}
