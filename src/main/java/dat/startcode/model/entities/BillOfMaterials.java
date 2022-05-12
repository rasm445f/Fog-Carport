package dat.startcode.model.entities;

public class BillOfMaterials {

    public BillOfMaterials(int materialAmount, int materialID, String materialGuidance) {
        this.materialAmount = materialAmount;
        this.materialID = materialID;
        this.materialGuidance = materialGuidance;
    }
    int materialAmount = 0;
    int materialID = 0;
    String materialGuidance = "";

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
