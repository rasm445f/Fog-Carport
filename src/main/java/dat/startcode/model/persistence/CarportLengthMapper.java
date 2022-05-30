package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportLength;
import dat.startcode.model.entities.CarportLength;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static dat.startcode.model.config.ApplicationStart.connectionPool;

public class CarportLengthMapper {
    ConnectionPool connectionPool;

    public CarportLengthMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ArrayList<CarportLength> createCarportLength(){
        String sql = "SELECT * FROM carport_Length;";
        ArrayList<CarportLength> carportLengthsList = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int carport_length_id = rs.getInt("carport_length_id");
                    int carport_length_cm = rs.getInt("carport_length_cm");
                    CarportLength carportLength = new CarportLength(carport_length_id,carport_length_cm);
                    carportLengthsList.add(carportLength);
                }
            }
        }catch (SQLException e){
            System.out.println("couldn't find carport length");
        }
        return carportLengthsList;

    }
    public CarportLength getSpecificCarportLength(int id){
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "SELECT * FROM carport_Length WHERE carport_Length_id = " + id;
        try (Connection connection = connectionPool.getConnection()){
            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int carport_Length_id = rs.getInt("carport_length_id");
                    int carport_Length_cm = rs.getInt("carport_length_cm");
                    CarportLength carportLength = new CarportLength(carport_Length_id, carport_Length_cm);
                    return carportLength;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch (SQLException e){
            System.out.println("Couldn't find carport Length");
        }
        return null;
    }
}
