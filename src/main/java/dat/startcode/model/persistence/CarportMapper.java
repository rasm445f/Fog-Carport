package dat.startcode.model.persistence;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarportMapper {
    ConnectionPool connectionPool;

    public CarportMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Carport createCarport(int width_id, int length_id, int rooftype_id, int toolshed_id) throws DatabaseException {
        Carport carport;
        String sql = "INSERT INTO carport (`width_id`, `length_id`, `rooftype_id`, `toolshed_id`) VALUES (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, width_id);
                ps.setInt(2, length_id);
                ps.setInt(3, rooftype_id);
                ps.setInt(4, toolshed_id);


                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {

                    carport = new Carport(width_id, length_id, rooftype_id, toolshed_id);

                } else {
                    throw new DatabaseException("The carport couldn't be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not into carport into database");
        }
        return carport;
    }

    public ArrayList<Carport> getCarport() {

        String sql = "SELECT * FROM carport;";
        ArrayList<Carport> carportsList = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carport_width_id = rs.getInt("width_id");
                    int carportLengthID = rs.getInt("length_id");
                    int rooftypeID = rs.getInt("rooftype_id");
                    int toolshedID = rs.getInt("toolshed_id");
                    int orderID = rs.getInt("order_id");
                    Carport carport = new Carport(carport_width_id, carportLengthID, rooftypeID, toolshedID, orderID);
                    carportsList.add(carport);
                }
            }
        } catch (SQLException e) {
            System.out.println("couldn't find carport");
        }
        return carportsList;
    }
}
