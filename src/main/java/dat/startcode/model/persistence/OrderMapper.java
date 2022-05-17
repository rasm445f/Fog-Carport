package dat.startcode.model.persistence;

import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.ToolshedWidth;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import static dat.startcode.model.config.ApplicationStart.connectionPool;

public class OrderMapper {
    ConnectionPool connectionPool;

    public OrderMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Order createOrder(int user_id, int order_price) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        Order order;
        String sql = "INSERT INTO fogcarport.order (user_id,order_price) values (?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, user_id);
                ps.setInt(2, order_price);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {

                    order = new Order(user_id, order_price);
                } else {
                    throw new DatabaseException("The order could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert the order into database");
        }
        return order;
    }

    public Order getNewestOrderID () throws DatabaseException{

        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "SELECT MAX(order_id) FROM fogcarport.order";
        Order order = null;

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    int order_id = rs.getInt("MAX(order_id)");
                    order = new Order(order_id);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Newest order_id could not be found");
        }

        return order;
    }

    public int getOrderIDFromUserID(int user_id) throws DatabaseException{

        Logger.getLogger("web").log(Level.INFO, "");
        int order_id = 0;
        String sql ="SELECT order_id FROM fogcarport.order WHERE user_id ="+user_id;

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    order_id = rs.getInt("order_id");

                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Order_id could not be found");
        }

        return order_id;
    }

    public void deleteOrder(int order_id) throws DatabaseException{

        Logger.getLogger("web").log(Level.INFO, "");
        String sqlone ="delete from `order` where order_id = ?;";
        String sqltwo ="delete from `bill_of_materials` where order_id = ?;";
        String sqlthree ="delete from `carport` where order_id = ?;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sqlone)) {
                ps.setInt(1,order_id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sqltwo)) {
                ps.setInt(1,order_id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sqlthree)) {
                ps.setInt(1,order_id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderStatus (int order_id, int order_status) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE fogcarport.order SET order_status ="+order_status+" WHERE order_id =" + order_id;

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrderPrice (int order_id, int order_price) throws DatabaseException{
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "UPDATE fogcarport.order SET order_price ="+order_price+" WHERE order_id =" + order_id;

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
