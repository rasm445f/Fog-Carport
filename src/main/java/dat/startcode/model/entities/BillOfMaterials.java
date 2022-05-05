package dat.startcode.model.entities;

public class BillOfMaterials {
    int materialAmount;
    int materialID;

    public BillOfMaterials(int materialAmount, int materialID) {
        this.materialAmount = materialAmount;
        this.materialID = materialID;
    }

    public int getMaterialAmount() {
        return materialAmount;
    }

    public int getMaterialID() {
        return materialID;
    }
}
