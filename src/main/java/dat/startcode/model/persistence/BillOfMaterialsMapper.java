package dat.startcode.model.persistence;

import dat.startcode.model.entities.BillOfMaterials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dat.startcode.model.config.ApplicationStart.connectionPool;

public class BillOfMaterialsMapper {
    ConnectionPool connectionPool;
    public BillOfMaterialsMapper(ConnectionPool connectionPool){this.connectionPool = connectionPool;}
    public ArrayList<BillOfMaterials> createbillOfMaterials(){
        String sql = "SELECT * FROM carport_width;";
        ArrayList<BillOfMaterials> billOfMaterialssList = new ArrayList<>();
        try{
            Connection connection = connectionPool.getConnection();
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int materialAmount = rs.getInt("material_amount");
                    int materialID = rs.getInt("material_id");
                    BillOfMaterials billOfMaterials = new BillOfMaterials(materialAmount,materialID);
                    billOfMaterialssList.add(billOfMaterials);
                }
            }
        }catch (SQLException e){
            System.out.println("couldn't find BOM width");
        }
        return billOfMaterialssList;

    }
}
