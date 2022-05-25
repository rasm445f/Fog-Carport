package dat.startcode.persistence;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class CarportMapperTest {
    private final static String USER = "cphbusiness";
    private final static String PASSWORD = "cph";
    private final static String URL = "jdbc:mysql://localhost:3306/fogcarport_test?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";
    private static OrderMapper orderMapper;
    private static ToolshedMapper toolshedMapper;
    private static ConnectionPool connectionPool;


    @BeforeEach
    void setUp()
    {
        try (Connection testConnection = connectionPool.getConnection()) {
            try (Statement stmt = testConnection.createStatement() ) {

                stmt.execute("delete from carport");

                stmt.execute("insert into carport (width_id,length_id,rooftype_id ) " +
                        "values ('3','5','1')");
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            fail("Database connection failed");
        }
    }

    @Test
    void testConnection() throws SQLException
    {
        Connection connection = connectionPool.getConnection();
        assertNotNull(connection);
        if (connection != null)
        {
            connection.close();
        }
    }

    @Test
    void insertCarport() throws DatabaseException{
        CarportMapper carportMapper = new CarportMapper(connectionPool);
        Carport carport;
        carport = carportMapper.createCarport(3,5,1,1);
        Carport expectedCarport = new Carport(3,5,1);
        assertEquals(expectedCarport,carport);


    }


}
