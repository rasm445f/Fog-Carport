package dat.startcode.model.entities;

import java.util.Date;

public class Order {
    int order_id;
    int userID;
    int orderPrice;
    int orderStatus;


    public Order(int userID, int orderPrice) {
        this.userID = userID;
        this.orderPrice = orderPrice;
    }

    public Order(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getUserID() {
        return userID;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }
}
