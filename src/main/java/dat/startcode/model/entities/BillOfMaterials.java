package dat.startcode.model.entities;

public class BillOfMaterials {

    int materialAmount;
    int materialID;
    String materialGuidance;

    public BillOfMaterials(int materialAmount, int materialID, String materialGuidance) {
        this.materialAmount = materialAmount;
        this.materialID = materialID;
        this.materialGuidance = materialGuidance;
    }

    public int getMaterialAmount() {
        return materialAmount;
    }

    public int getMaterialID() {
        return materialID;
    }

    public String getMaterialGuidance(){
        return materialGuidance;
    }
}
