package dat.startcode.model.entities;

public class BillOfMaterials {

    int bom_id;
    int materialAmount = 0;
    int materialID = 0;
    String materialGuidance = "";
    int orderID = 0;

    String materialDescription;
    String materialUnit;
    int materialLength;

    public BillOfMaterials(int bom_id, int materialAmount, int materialID, String materialGuidance, int orderID) {
        this.bom_id = bom_id;
        this.materialAmount = materialAmount;
        this.materialID = materialID;
        this.materialGuidance = materialGuidance;
        this.orderID = orderID;
    }

    public BillOfMaterials(int bom_id, int materialAmount, String materialGuidance, String materialDescription, String materialUnit, int materialLength) {
        this.bom_id = bom_id;
        this.materialAmount = materialAmount;
        this.materialGuidance = materialGuidance;
        this.materialDescription = materialDescription;
        this.materialUnit = materialUnit;
        this.materialLength = materialLength;
    }

    public int getBom_id() {
        return bom_id;
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

    public int getOrderID() {
        return orderID;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public int getMaterialLength() {
        return materialLength;
    }
}
