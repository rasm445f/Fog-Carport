package dat.startcode.model.entities;

public class Materials {
    int materialID;
    String materialDescription;
    String materialCategory;
    String materialUnit;
    int materialPrice;

    public Materials(int materialID,String materialDescription, String materialCategory, String materialUnit, int materialPrice) {
        this.materialID = materialID;
        this.materialDescription = materialDescription;
        this.materialCategory = materialCategory;
        this.materialUnit = materialUnit;
        this.materialPrice = materialPrice;
    }

    public int getMaterialID() {
        return materialID;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public String getMaterialCategory() {
        return materialCategory;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public int getMaterialPrice() {
        return materialPrice;
    }
}
