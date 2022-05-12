package dat.startcode.model.entities;

public class Carport {

    private int carportWidthID;
    private int carportLengthID;
    private int rooftypeID;
    private int carportLengthCM;
    private int carportWidthCM;
    private String roofName;
    private int toolshedLengthCM;
    private int toolshedWidthCM;

    public Carport(int carportWidthID, int carportLengthID, int rooftypeID) {
        this.carportWidthID = carportWidthID;
        this.carportLengthID = carportLengthID;
        this.rooftypeID = rooftypeID;

    }

    public Carport(int carportLengthCM, int carportWidthCM, String roofName, int toolshedLengthCM, int toolshedWidthCM) {
        this.carportLengthCM = carportLengthCM;
        this.carportWidthCM = carportWidthCM;
        this.roofName = roofName;
        this.toolshedLengthCM = toolshedLengthCM;
        this.toolshedWidthCM = toolshedWidthCM;
    }

    public int getCarportWidthID() {
        return carportWidthID;
    }

    public int getCarportLengthID() {
        return carportLengthID;
    }

    public int getRooftypeID() {
        return rooftypeID;
    }

    public int getCarportLengthCM() {
        return carportLengthCM;
    }

    public int getCarportWidthCM() {
        return carportWidthCM;
    }

    public String getRoofName() {
        return roofName;
    }

    public int getToolshedLengthCM() {
        return toolshedLengthCM;
    }

    public int getToolshedWidthCM() {
        return toolshedWidthCM;
    }
}
