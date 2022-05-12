package dat.startcode.model.persistence;

import dat.startcode.model.entities.Toolshed;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToolshedMapper {

    ConnectionPool connectionPool;

    public ToolshedMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public Toolshed insertToolshed(int toolshed_width_id, int toolshed_length_id) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "insert into toolshed (toolshed_width_id, toolshed_length_id) values (?,?)";
        Toolshed toolshed;

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, toolshed_width_id);
                ps.setInt(2, toolshed_length_id);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {

                    toolshed = new Toolshed(toolshed_width_id, toolshed_length_id);

                } else {
                    throw new DatabaseException("Could not insert toolshed into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert toolshed into database");
        }

        return toolshed;
    }
}

