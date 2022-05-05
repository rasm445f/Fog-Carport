package dat.startcode.model.entities;

import java.util.Date;

public class Order {
    int userID;
    Date orderDate;
    int orderPrice;
    int orderStatusNumbers;
    int bomID;
    boolean orderStatus;
    public Order(int userID, Date orderDate, int orderPrice, int orderStatusNumbers, int bomID) {
        this.userID = userID;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.orderStatusNumbers = orderStatusNumbers;
        this.bomID = bomID;
        if (orderStatusNumbers == 0){
            orderStatus = false;
        }
        else{ orderStatus = true;}
    }
}
