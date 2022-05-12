package dat.startcode.model.entities;

public class BillOfMaterials {

    public BillOfMaterials(int materialAmount, int materialID, String materialGuidance, int orderID) {
        this.materialAmount = materialAmount;
        this.materialID = materialID;
        this.materialGuidance = materialGuidance;
        this.orderID = orderID;

    }
    int materialAmount = 0;
    int materialID = 0;
    String materialGuidance = "";
    int orderID = 0;

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
