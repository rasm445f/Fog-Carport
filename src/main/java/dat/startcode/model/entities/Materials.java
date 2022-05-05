package dat.startcode.model.entities;

public class Materials {
    String materialDescription;
    String materialGuidance;
    String materialCategory;
    String materialUnit;
    int materialLength;
    int materialPrice;

    public Materials(String materialDescription, String materialGuidance, String materialCategory, String materialUnit, int materialLength, int materialPrice) {
        this.materialDescription = materialDescription;
        this.materialGuidance = materialGuidance;
        this.materialCategory = materialCategory;
        this.materialUnit = materialUnit;
        this.materialLength = materialLength;
        this.materialPrice = materialPrice;
    }
}
