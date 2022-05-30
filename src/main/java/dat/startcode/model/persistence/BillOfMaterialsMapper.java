package dat.startcode.model.persistence;

import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.entities.Carport;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.services.CalculatorService;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static dat.startcode.model.config.ApplicationStart.connectionPool;

public class BillOfMaterialsMapper {
    private ConnectionPool connectionPool;

    public BillOfMaterialsMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;}


    public ArrayList<BillOfMaterials> getBOM() throws DatabaseException{
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "SELECT * FROM fogcarport.bill_of_materials;";
        ArrayList<BillOfMaterials> billOfMaterialsList = new ArrayList<>();
        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int bom_id = rs.getInt("bom_id");
                    int materialAmount = rs.getInt("material_amount");
                    int materialID = rs.getInt("material_id");
                    String materialGuidance = rs.getString("material_guidance");
                    int orderID = rs.getInt("order_id");
                    BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,materialAmount,materialID,materialGuidance,orderID);
                    billOfMaterialsList.add(billOfMaterials);
                }
            }
        }catch (SQLException e){
            System.out.println("couldn't find BOM width");
        }
        return billOfMaterialsList;

    }


    public ArrayList<BillOfMaterials> createBOM(ArrayList<BillOfMaterials> billOfMaterialsList) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<BillOfMaterials> bomList = billOfMaterialsList;
        String sql = "INSERT INTO fogcarport.bill_of_materials (bom_id,material_amount,material_guidance,material_id,order_id) VALUES (?,?,?,?,?);";

        int bom_id = 0;
        int material_amount =  0;
        int material_id = 0;
        String material_guidance ="";
        int order_id = 0;



        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                for (BillOfMaterials bill : bomList) {
                    bom_id = bill.getBom_id();
                    material_amount = bill.getMaterialAmount();
                    material_id = bill.getMaterialID();
                    material_guidance = bill.getMaterialGuidance();
                    order_id = bill.getOrderID();

                    ps.setInt(1, bom_id);
                    ps.setInt(2, material_amount);
                    ps.setString(3, material_guidance);
                    ps.setInt(4, material_id);
                    ps.setInt(5, order_id);

                    ps.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert bom into database");
        }
        return bomList;
    }
    public ArrayList<BillOfMaterials>  selectSpecificBOM(int bomID){
        String sql = "SELECT * FROM bill_of_materials b inner join materials m on b.material_id = m.material_id where bom_id = ?;";
        ArrayList<BillOfMaterials> bomSpecifications = new ArrayList<>();
        int bom_id;
        int materialAmount;
        String materialGuiance;
        String materialDescription;
        String materialUnit;
        int materialLength;
        try(Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1,bomID);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    bom_id = rs.getInt("bom_id");
                    materialDescription = rs.getString("material_description");
                    materialLength = rs.getInt("material_length");
                    materialAmount = rs.getInt("material_amount");
                    materialUnit = rs.getString("material_unit");
                    materialGuiance = rs.getString("material_guidance");
                    BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,materialAmount,materialGuiance,materialDescription,materialUnit,materialLength);
                    bomSpecifications.add(billOfMaterials);
                }
            }
        }catch (SQLException e)
        {

        }
        return bomSpecifications;
    }
}
