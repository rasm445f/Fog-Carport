package dat.startcode.model.persistence;

import dat.startcode.model.entities.Materials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialsMapper {
    ConnectionPool connectionPool;

    public MaterialsMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ArrayList<Materials> CreateMaterials(){
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "SELECT * FROM fogcarport.materials;";
        ArrayList<Materials> materialList = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement(sql)){

                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int materialID = rs.getInt("material_id");
                    String materialDescription = rs.getString("material_description");
                    String materialCategory = rs.getString("material_category");
                    int materialLength = rs.getInt("material_length");
                    String materialUnit = rs.getString("material_unit");
                    int materialPrice = rs.getInt("material_price");
                    Materials materials = new Materials(materialID,materialDescription,materialCategory,materialLength,materialUnit,materialPrice);
                    materialList.add(materials);
                }
            }
        }catch (SQLException e){
            System.out.println("Couldn't find the materials in the database");
        }
        return materialList;
    }
}
