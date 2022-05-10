package dat.startcode.model.entities;

public class Materials {
    int materialID;
    String materialDescription;
    String materialCategory;
    int materialLength;
    String materialUnit;
    int materialPrice;

    public Materials(int materialID,String materialDescription, String materialCategory,int materialLength, String materialUnit, int materialPrice) {
        this.materialID = materialID;
        this.materialDescription = materialDescription;
        this.materialCategory = materialCategory;
        this.materialLength = materialLength;
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

    public int getMaterialLength() {
        return materialLength;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public int getMaterialPrice() {
        return materialPrice;
    }
}
