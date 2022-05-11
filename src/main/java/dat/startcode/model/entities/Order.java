package dat.startcode.model.entities;

import java.util.Date;

public class Order {
    int order_id;
    int userID;
    Date orderDate;
    int orderPrice;
    int orderStatus;


    public Order(int userID, int orderPrice) {
        this.userID = userID;
        this.orderPrice = orderPrice;

    }

    public int getOrder_id() {
        return order_id;
    }

    public int getUserID() {
        return userID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }
}
