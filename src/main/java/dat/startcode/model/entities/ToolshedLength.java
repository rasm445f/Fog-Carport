package dat.startcode.model.entities;

public class ToolshedLength {
    private int toolshedLengthID;
    private int toolshedLength;

    public ToolshedLength(int toolshedLengthID, int toolshedLength) {
        this.toolshedLengthID = toolshedLengthID;
        this.toolshedLength = toolshedLength;
    }

    public int getToolshedLengthID() {
        return toolshedLengthID;
    }

    public int getToolshedLength() {
        return toolshedLength;
    }
}
