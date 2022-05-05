package dat.startcode.model.persistence;

import dat.startcode.model.entities.Carport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarportMapper {
    ConnectionPool connectionPool;
    public CarportMapper(ConnectionPool connectionPool){this.connectionPool = connectionPool;}
    public ArrayList<Carport> createCarport(){
        String sql = "SELECT * FROM carport_;";
        ArrayList<Carport> carportsList = new ArrayList<>();
        try{
            Connection connection = connectionPool.getConnection();
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int carportWidthID = rs.getInt("width_id");
                    int carportLengthID = rs.getInt("length_id");
                    int rooftypeID = rs.getInt("rooftype_id");
                    int toolshedID = rs.getInt("toolshed_id");
                    int orderID = rs.getInt("order_id");
                    Carport carport = new Carport(carportWidthID,carportLengthID,rooftypeID,toolshedID,orderID);
                    carportsList.add(carport);
                }
            }
        }catch (SQLException e){
            System.out.println("couldn't find carport");
        }
        return carportsList;

    }
}
