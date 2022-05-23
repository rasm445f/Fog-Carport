package dat.startcode.model.entities;

public class Materials {
    int materialID;
    String materialDescription;
    String materialCategory;
    int materialLength;
    String materialUnit;
    int materialPrice;
    int materialAmount;

    public Materials(int materialID,String materialDescription, String materialCategory,int materialLength, String materialUnit, int materialPrice) {
        this.materialID = materialID;
        this.materialDescription = materialDescription;
        this.materialCategory = materialCategory;
        this.materialLength = materialLength;
        this.materialUnit = materialUnit;
        this.materialPrice = materialPrice;
    }

    public Materials(int materialPrice, int materialAmount) {
        this.materialPrice = materialPrice;
        this.materialAmount = materialAmount;
    }

    public int getMaterialAmount() {
        return materialAmount;
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
