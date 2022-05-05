package dat.startcode.model.entities;

public class Carport {
    int carportWidthID;
    int carportLengthID;
    int rooftypeID;
    int toolshedID;
    int orderID;
    public Carport(int carportWidthID, int carportLengthID, int rooftypeID, int toolshedID, int orderID) {
        this.carportWidthID = carportWidthID;
        this.carportLengthID = carportLengthID;
        this.rooftypeID = rooftypeID;
        this.toolshedID = toolshedID;
        this.orderID = orderID;
    }
}
