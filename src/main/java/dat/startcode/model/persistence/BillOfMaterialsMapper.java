package dat.startcode.model.persistence;

import dat.startcode.model.entities.BillOfMaterials;

import javax.servlet.ServletContext;
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
        String sql = "SELECT * FROM fogcarport.bill_of_materials;";
        ArrayList<BillOfMaterials> billOfMaterialssList = new ArrayList<>();
        try{
            Connection connection = connectionPool.getConnection();
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int materialAmount = rs.getInt("material_amount");
                    int materialID = rs.getInt("material_id");
                    String materialGuidance = rs.getString("material_guidance");
                    int orderID = rs.getInt("order_id");
                    BillOfMaterials billOfMaterials = new BillOfMaterials(materialAmount,materialID,materialGuidance,orderID);
                    billOfMaterialssList.add(billOfMaterials);
                }
            }
        }catch (SQLException e){
            System.out.println("couldn't find BOM width");
        }
        return billOfMaterialssList;

    }
    public void insertBOMtoSQL(BillOfMaterials billOfMaterials){
        String sql = "INSERT INTO fogcarport.bill_pf_materials (bom_id,material_amount,material_guidance,material_id,order_id) VALUES (?,?,?,?,?);";
        try {
            Connection connection = connectionPool.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1,billOfMaterials.getOrderID());
                ps.setInt(2,billOfMaterials.getMaterialAmount());
                ps.setString(3,billOfMaterials.getMaterialGuidance());
                ps.setInt(4,billOfMaterials.getMaterialID());
                ps.setInt(5,billOfMaterials.getOrderID());
                ps.executeUpdate();
            }
            catch (Exception e){

            }

        }
        catch (SQLException e){

        }

    }

}
