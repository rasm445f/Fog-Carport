package dat.startcode.model.entities;

public class Rooftype {

    private int rooftypeID;
    private String roofName;

    public Rooftype(int rooftypeID, String roofName) {
        this.rooftypeID = rooftypeID;
        this.roofName = roofName;
    }

    public int getRooftypeID() {
        return rooftypeID;
    }

    public String getRoofName() {
        return roofName;
    }
}
