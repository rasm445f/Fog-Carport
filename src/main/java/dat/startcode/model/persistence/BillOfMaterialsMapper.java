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
        try{
            Connection connection = connectionPool.getConnection();
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
        ArrayList<BillOfMaterials> bomList = new ArrayList<>();
        CalculatorService calculatorService = new CalculatorService(connectionPool,1,1,1);
        bomList = calculatorService.calculateEverything();
        String sql = "INSERT INTO fogcarport.bill_of_materials (bom_id,material_amount,material_guidance,material_id,order_id) VALUES (?,?,?,?,?);";

        int bom_id = 0;
        int material_amount =  0;
        int material_id = 0;
        String material_guidance ="";
        int order_id = 0;

        for (BillOfMaterials bill : bomList) {
            bom_id = bill.getBom_id();
            material_amount = bill.getMaterialAmount();
            material_id = bill.getMaterialID();
            material_guidance  = bill.getMaterialGuidance();
            order_id = bill.getOrderID();
        }


        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1,bom_id);
                ps.setInt(2,material_amount);
                ps.setString(3,material_guidance);
                ps.setInt(4,material_id);
                ps.setInt(5,order_id);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {

                     BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,material_amount,material_id,material_guidance,order_id);
                     bomList.add(billOfMaterials);

                } else {
                    throw new DatabaseException("The bom couldn't be inserted into the database");
                }
            }

        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert bom into database");
        }
        return bomList;
    }

}
