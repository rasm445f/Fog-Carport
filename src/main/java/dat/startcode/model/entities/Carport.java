package dat.startcode.model.entities;

public class Carport {

    private int carportWidthID;
    private int carportLengthID;
    private int rooftypeID;
    private int carportLengthCM;
    private int carportWidthCM;
    private String roofName;
    private int toolshedLengthCM;
    private int toolshedWidthCM;
    private int order_id;
    private String customerName;
    private int order_price;
    private int order_status;

    public Carport(int order_id, String customerName,int order_price, int order_status,int carportLengthCM, int carportWidthCM, String roofName, int toolshedLengthCM, int toolshedWidthCM ) {
        this.carportLengthCM = carportLengthCM;
        this.carportWidthCM = carportWidthCM;
        this.roofName = roofName;
        this.toolshedLengthCM = toolshedLengthCM;
        this.toolshedWidthCM = toolshedWidthCM;
        this.order_id = order_id;
        this.customerName = customerName;
        this.order_price = order_price;
        this.order_status = order_status;
    }

    public Carport(int carportWidthID, int carportLengthID, int rooftypeID) {
        this.carportWidthID = carportWidthID;
        this.carportLengthID = carportLengthID;
        this.rooftypeID = rooftypeID;

    }

    public Carport(int carportLengthCM, int carportWidthCM, String roofName, int toolshedLengthCM, int toolshedWidthCM, int order_id, int order_price, int order_status) {
        this.carportLengthCM = carportLengthCM;
        this.carportWidthCM = carportWidthCM;
        this.roofName = roofName;
        this.toolshedLengthCM = toolshedLengthCM;
        this.toolshedWidthCM = toolshedWidthCM;
        this.order_id = order_id;
        this.order_price = order_price;
        this.order_status = order_status;
    }

    public Carport(int carportLengthCM, int carportWidthCM, String roofName, int toolshedLengthCM, int toolshedWidthCM) {
        this.carportLengthCM = carportLengthCM;
        this.carportWidthCM = carportWidthCM;
        this.roofName = roofName;
        this.toolshedLengthCM = toolshedLengthCM;
        this.toolshedWidthCM = toolshedWidthCM;
    }

    public Carport(int carportLengthCM, int carportWidthCM, String roofName, int order_id, int order_price, int order_status) {
        this.carportLengthCM = carportLengthCM;
        this.carportWidthCM = carportWidthCM;
        this.roofName = roofName;
        this.order_id = order_id;
        this.order_price = order_price;
        this.order_status = order_status;
    }

    public Carport(int order_id, String customerName, int order_price, int order_status, int carportLengthCM, int carportWidthCM, String roofName) {
        this.carportLengthCM = carportLengthCM;
        this.carportWidthCM = carportWidthCM;
        this.roofName = roofName;
        this.order_id = order_id;
        this.customerName = customerName;
        this.order_price = order_price;
        this.order_status = order_status;
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

    public int getCarportLengthCM() {
        return carportLengthCM;
    }

    public int getCarportWidthCM() {
        return carportWidthCM;
    }

    public String getRoofName() {
        return roofName;
    }

    public int getToolshedLengthCM() {
        return toolshedLengthCM;
    }

    public int getToolshedWidthCM() {
        return toolshedWidthCM;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getOrder_price() {
        return order_price;
    }

    public int getOrder_status() {
        return order_status;
    }
}
