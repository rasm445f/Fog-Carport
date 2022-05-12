package dat.startcode.model.persistence;

import dat.startcode.model.entities.Rooftype;
import dat.startcode.model.entities.ToolshedLength;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RooftypeMapper {
    ConnectionPool connectionPool;

    public RooftypeMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ArrayList<Rooftype> getRooftype() throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<Rooftype> rooftypeList = new ArrayList<>();
        String sql = "SELECT * FROM fogcarport.rooftype";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int rooftype_id = rs.getInt("rooftype_id");
                    String rooftypeName = rs.getString("roof_name");
                    Rooftype rooftype = new Rooftype(rooftype_id,rooftypeName);
                    rooftypeList.add(rooftype);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Rooftype name could not be found");
        }

        return rooftypeList;
    }
}
