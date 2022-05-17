package dat.startcode.model.persistence;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Toolshed;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarportMapper {
    ConnectionPool connectionPool;

    public CarportMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Carport createCarport(int width_id, int length_id, int rooftype_id, int order_id) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        Carport carport;
        String sql = "INSERT INTO carport (`width_id`, `length_id`, `rooftype_id`,`toolshed_id`,`order_id` ) VALUES (?,?,?,(SELECT MAX(toolshed_id) as toolshed_id FROM toolshed),?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, width_id);
                ps.setInt(2, length_id);
                ps.setInt(3, rooftype_id);
                ps.setInt(4,order_id);



                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {

                    carport = new Carport(width_id, length_id, rooftype_id);

                } else {
                    throw new DatabaseException("The carport couldn't be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert carport into database");
        }
        return carport;
    }

    public ArrayList<Carport> getCarportData(int user_id) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM carport c\n" +
                "inner join carport_length cl on c.length_id = cl.carport_length_id\n" +
                "inner join carport_width cw on c.width_id = cw.carport_width_id\n" +
                "inner join rooftype rt on c.rooftype_id = rt.rooftype_id\n" +
                "inner join toolshed ts on c.toolshed_id = ts.toolshed_id\n" +
                "inner join toolshed_length tl on c.rooftype_id = tl.toolshed_length_id\n" +
                "inner join toolshed_width tw on c.rooftype_id = tw.toolshed_width_id\n" +
                "inner join fogcarport.order o on c.order_id = o.order_id\n" +
                "WHERE user_id ="+user_id;
        ArrayList<Carport> carportsList = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int order_price = rs.getInt("order_price");
                    int order_status = rs.getInt("order_status");
                    int carportLengthCM = rs.getInt("carport_length_cm");
                    int carportWidthCM = rs.getInt("carport_width_cm");
                    String roofName = rs.getString("roof_name");
                    int toolshedLengthCM = rs.getInt("toolshed_length_cm");
                    int toolshedWidthCM = rs.getInt("toolshed_width_cm");

                    Carport carport = new Carport(carportLengthCM,carportWidthCM,roofName,toolshedLengthCM,toolshedWidthCM,order_id,order_price,order_status);
                    carportsList.add(carport);
                }
            }
        } catch (SQLException e) {
            System.out.println("Couldn't find carport");
        }
        return carportsList;
    }
    public ArrayList<Carport> getCarportDataAdmin() throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM carport c\n" +
                "inner join carport_length cl on c.length_id = cl.carport_length_id\n" +
                "inner join carport_width cw on c.width_id = cw.carport_width_id\n" +
                "inner join rooftype rt on c.rooftype_id = rt.rooftype_id\n" +
                "inner join toolshed ts on c.toolshed_id = ts.toolshed_id\n" +
                "inner join toolshed_length tl on c.rooftype_id = tl.toolshed_length_id\n" +
                "inner join toolshed_width tw on c.rooftype_id = tw.toolshed_width_id\n" +
                "inner join fogcarport.order o on c.order_id = o.order_id\n" +
                "inner join user u on o.user_id = u.user_id;\n";

        ArrayList<Carport> carportsListAdmin = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    String customerName = rs.getString("name");
                    int order_price = rs.getInt("order_price");
                    int order_status = rs.getInt("order_status");
                    int carportLengthCM = rs.getInt("carport_length_cm");
                    int carportWidthCM = rs.getInt("carport_width_cm");
                    String roofName = rs.getString("roof_name");
                    int toolshedLengthCM = rs.getInt("toolshed_length_cm");
                    int toolshedWidthCM = rs.getInt("toolshed_width_cm");

                    Carport carport = new Carport(order_id,customerName,order_price,order_status,carportLengthCM,carportWidthCM,roofName,toolshedLengthCM,toolshedWidthCM);
                    carportsListAdmin.add(carport);
                }
            }
        } catch (SQLException e) {
            System.out.println("Couldn't find carport");
        }
        return carportsListAdmin;
    }
}
