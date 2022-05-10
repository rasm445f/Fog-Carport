package dat.startcode.model.entities;

public class Carport {

    private int carportID;
    private int carportWidthID;
    private int carportLengthID;
    private int  rooftypeID;
    private int toolshedID;
    private int orderID;

    public Carport(int carportWidthID, int carportLengthID, int rooftypeID, int toolshedID, int orderID) {
        this.carportWidthID = carportWidthID;
        this.carportLengthID = carportLengthID;
        this.rooftypeID = rooftypeID;
        this.toolshedID = toolshedID;
        this.orderID = orderID;

    }

    public Carport(int carportWidthID, int carportLengthID, int rooftypeID) {
        this.carportWidthID = carportWidthID;
        this.carportLengthID = carportLengthID;
        this.rooftypeID = rooftypeID;

    }

    public int getCarportID() {
        return carportID;
    }

    public int getCarportWidthID() {
        return carportWidthID;
    }

    public int getCarportLengthID() {
        return carportLengthID;
    }

    public int getRooftypeID() {
        return rooftypeID;
    }

    public int getToolshedID() {
        return toolshedID;
    }

    public int getOrderID() {
        return orderID;
    }
}
