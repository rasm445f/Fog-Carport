package dat.startcode.model.persistence;

import dat.startcode.model.entities.ToolshedWidth;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToolshedWidthMapper {

    ConnectionPool connectionPool;

    public ToolshedWidthMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public ArrayList<ToolshedWidth> GetToolshedWidth () throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<ToolshedWidth> toolshedWidthList = new ArrayList<>();
        String sql = "SELECT * FROM fogcarport.toolshed_width";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int toolshed_width_id = rs.getInt("toolshed_width_id");
                    int toolshed_width_cm = rs.getInt("toolshed_width_cm");
                    ToolshedWidth toolshedWidth = new ToolshedWidth(toolshed_width_id,toolshed_width_cm);
                    toolshedWidthList.add(toolshedWidth);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Toolshed width could not be found");
        }
        return toolshedWidthList;
    }
}
