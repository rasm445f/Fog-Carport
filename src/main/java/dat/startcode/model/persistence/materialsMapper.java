package dat.startcode.model.persistence;

import dat.startcode.model.entities.Materials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dat.startcode.model.config.ApplicationStart.connectionPool;

public class materialsMapper {
    public ArrayList<Materials> creatematerials(){
        String sql = "SELECT * FROM carport_Length;";
        ArrayList<Materials> materialssList = new ArrayList<>();
        try{
            Connection connection = connectionPool.getConnection();
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    String materialDescription = rs.getString("material_description");
                    String materialGuidance = rs.getString("material_guidance");
                    String materialCategory = rs.getString("material_category");
                    String materialUnit = rs.getString("material_unit");
                    int materialLength = rs.getInt("material_length");
                    int materialPrice = rs.getInt("material_price");
                    Materials materials = new Materials(materialDescription,materialGuidance,materialCategory,materialUnit,materialLength,materialPrice);
                    materialssList.add(materials);
                }
            }
        }catch (SQLException e){
            System.out.println("couldn't find carport length");
        }
        return materialssList;

    }
}
