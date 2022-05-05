package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportLength;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dat.startcode.model.config.ApplicationStart.connectionPool;

public class carportLengthMapper {
    public ArrayList<CarportLength> createCarportLength(){
        String sql = "SELECT * FROM carport_Length;";
        ArrayList<CarportLength> carportLengthsList = new ArrayList<>();
        try{
            Connection connection = connectionPool.getConnection();
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int carportLengthCM = rs.getInt("carport_length_cm");
                    CarportLength carportLength = new CarportLength(carportLengthCM);
                    carportLengthsList.add(carportLength);
                }
            }
        }catch (SQLException e){
            System.out.println("couldn't find carport length");
        }
        return carportLengthsList;

    }
}
