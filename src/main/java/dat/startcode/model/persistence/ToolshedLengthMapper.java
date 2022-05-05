package dat.startcode.model.persistence;

import dat.startcode.model.entities.ToolshedLength;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToolshedLengthMapper {
    ConnectionPool connectionPool;

    public ToolshedLengthMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ArrayList<ToolshedLength> GetToolshedLength () throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<ToolshedLength> toolshedLengthList = new ArrayList<>();
        String sql = "SELECT * FROM fogcarport.toolshed_length";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int length_cm = rs.getInt("toolshed_length_cm");
                    ToolshedLength toolshedLength = new ToolshedLength(length_cm);
                    toolshedLengthList.add(toolshedLength);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Toolshed length could not be found");
        }
        return toolshedLengthList;
    }
}


