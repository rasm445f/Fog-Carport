package dat.startcode.model.persistence;

import dat.startcode.model.entities.Materials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialsMapper {
    ConnectionPool connectionPool;

    public MaterialsMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    public ArrayList<Materials> createMaterials(){
        String sql = "SELECT * FROM fogcarport.materials;";
        ArrayList<Materials> materialList = new ArrayList<>();
        try{
            Connection connection = connectionPool.getConnection();
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    String materialDescription = rs.getString("material_description");
                    String materialCategory = rs.getString("material_category");
                    String materialUnit = rs.getString("material_unit");
                    int materialLength = rs.getInt("material_length");
                    String materialDimension = rs.getString("material_dimension");
                    int materialPrice = rs.getInt("material_price");
                    Materials materials = new Materials(materialDescription,materialCategory,materialUnit,materialLength, materialDimension,materialPrice);
                    materialList.add(materials);
                }
            }
        }catch (SQLException e){
            System.out.println("couldn't find the materials in the database");
        }
        return materialList;

    }
}
