package dat.startcode.model.entities;

public class Materials {
    int materialID;
    String materialDescription;
    String materialCategory;
    String materialUnit;
    String materialDimension;
    int materialPrice;

    public Materials(int materialID,String materialDescription, String materialCategory, String materialUnit, String materialDimension, int materialPrice) {
        this.materialID = materialID;
        this.materialDescription = materialDescription;
        this.materialCategory = materialCategory;
        this.materialUnit = materialUnit;
        this.materialDimension = materialDimension;
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

    public String getMaterialDimension() {
        return materialDimension;
    }

    public int getMaterialPrice() {
        return materialPrice;
    }
}
