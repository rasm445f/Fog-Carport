package dat.startcode.model.entities;

public class ToolshedWidth {

    private int toolshedID;
    private int toolshedWidth;

    public ToolshedWidth(int toolshedID, int toolshedWidth) {
        this.toolshedID = toolshedID;
        this.toolshedWidth = toolshedWidth;
    }

    public int getToolshedID() {
        return toolshedID;
    }

    public int getToolshedWidth() {
        return toolshedWidth;
    }
}
