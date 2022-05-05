package dat.startcode.model.persistence;

import dat.startcode.model.entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import static dat.startcode.model.config.ApplicationStart.connectionPool;

public class orderMapper {
    public ArrayList<Order> createorder(){
        String sql = "SELECT * FROM carport_Length;";
        ArrayList<Order> ordersList = new ArrayList<>();
        try{
            Connection connection = connectionPool.getConnection();
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int userID = rs.getInt("user_id");
                    Date orderDate = rs.getDate("order_date");
                    int orderPrice = rs.getInt("order_price");
                    int orderStatus = rs.getInt("order_status");
                    int bomID = rs.getInt("bom_id");
                    Order order = new Order(userID,orderDate,orderPrice,orderStatus,bomID);
                    ordersList.add(order);
                }
            }
        }catch (SQLException e){
            System.out.println("couldn't find carport length");
        }
        return ordersList;

    }
}
