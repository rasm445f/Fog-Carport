package dat.startcode.model.persistence;

import dat.startcode.model.entities.CarportWidth;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dat.startcode.model.config.ApplicationStart.connectionPool;

public class CarportWidthMapper {
    ConnectionPool connectionPool;

    public CarportWidthMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ArrayList<CarportWidth> createCarportwidth(){
    String sql = "SELECT * FROM carport_width;";
    ArrayList<CarportWidth> carportWidthsList = new ArrayList<>();
    try{
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int carportWidthCM = rs.getInt("carport_width_cm");
                CarportWidth carportWidth = new CarportWidth(carportWidthCM);
                carportWidthsList.add(carportWidth);
            }
        }
    }catch (SQLException e){
        System.out.println("couldn't find carport width");
    }
    return carportWidthsList;

}
}
