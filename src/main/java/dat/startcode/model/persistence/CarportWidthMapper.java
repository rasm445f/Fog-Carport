package dat.startcode.model.persistence;


import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.CarportWidth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarportWidthMapper {
    ConnectionPool connectionPool;

    public CarportWidthMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ArrayList<CarportWidth> getCarportWidth() {

        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "SELECT * FROM carport_width;";
        ArrayList<CarportWidth> carportWidthsList = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()){
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carport_width_id = rs.getInt("carport_width_id");
                    int carport_width_cm = rs.getInt("carport_width_cm");
                    CarportWidth carportWidth = new CarportWidth(carport_width_id, carport_width_cm);
                    carportWidthsList.add(carportWidth);
                }
            }
        } catch (SQLException e) {
            System.out.println("Couldn't find carport width");
        }

        return carportWidthsList;
    }
    public CarportWidth getSpecificCarportwidth(int id){
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "SELECT * FROM carport_width WHERE carport_width_id = " + id;
        try (Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int carport_width_id = rs.getInt("carport_width_id");
                int carport_width_cm = rs.getInt("carport_width_cm");
                CarportWidth carportWidth = new CarportWidth(carport_width_id, carport_width_cm);
                return carportWidth;
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (SQLException e){
            System.out.println("Couldn't find carport width");
        }
        return null;
    }
}
