package dat.startcode.model.persistence;

import dat.startcode.model.entities.Order;
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

    public void createOrder(int user_id, int order_price) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        Order order;
        
        String sql = "INSERT INTO order (user_id,order_price) values (?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, user_id);
                ps.setInt(3, order_price);


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

    }

}
