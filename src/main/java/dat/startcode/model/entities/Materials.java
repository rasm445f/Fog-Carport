package dat.startcode.model.entities;

public class Materials {
    int materialID;
    String materialDescription;
    String materialCategory;
    String materialUnit;
    int materialLength;
    String materialDimension;
    int materialPrice;

    public Materials(int materialID,String materialDescription, String materialCategory,int materialLength, String materialUnit, String materialDimension, int materialPrice) {
        this.materialID = materialID;
        this.materialDescription = materialDescription;
        this.materialCategory = materialCategory;
        this.materialLength = materialLength;
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

    public int getMaterialLength() {return materialLength;}

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
