package dat.startcode.model.entities;

import java.util.Date;

public class Order {
    int userID;
    Date orderDate;
    int orderPrice;
    boolean orderStatus;
    int bomID;

    public Order(int userID, Date orderDate, int orderPrice, boolean orderStatus, int bomID) {
        this.userID = userID;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
        this.bomID = bomID;
    }
}
