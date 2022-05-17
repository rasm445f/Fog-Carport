package dat.startcode.model.entities;

public class BillOfMaterials {

    int bom_id;
    int materialAmount = 0;
    int materialID = 0;
    String materialGuidance = "";
    int orderID = 0;

    public BillOfMaterials(int bom_id, int materialAmount, int materialID, String materialGuidance, int orderID) {
        this.bom_id = bom_id;
        this.materialAmount = materialAmount;
        this.materialID = materialID;
        this.materialGuidance = materialGuidance;
        this.orderID = orderID;

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
}
