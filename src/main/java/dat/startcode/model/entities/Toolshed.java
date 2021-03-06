package dat.startcode.model.entities;

public class Toolshed {

    private int toolshedID;
    private int toolshedWidth;
    private int toolshedLength;

    public Toolshed( int toolshedWidth, int toolshedLength) {
        this.toolshedWidth = toolshedWidth;
        this.toolshedLength = toolshedLength;
    }

    public int getToolshedID() {
        return toolshedID;
    }

    public int getToolshedWidth() {
        return toolshedWidth;
    }

    public int getToolshedLength() {
        return toolshedLength;
    }
}
