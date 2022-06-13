package dat.startcode.persistence;

import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.entities.Materials;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;
import dat.startcode.model.services.CalculatorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{
    private final static String USER = "cphbusiness";
    private final static String PASSWORD = "cph";
    private final static String URL = "jdbc:mysql://localhost:3306/fogcarport_test?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";

    private static ConnectionPool connectionPool;
    private static MaterialsMapper materialsMapper;
    private ArrayList<Materials> materialList = materialsMapper.CreateMaterials();
    private ArrayList<BillOfMaterials> BOMList = new ArrayList<>();
    CalculatorService calculatorService = new CalculatorService(connectionPool,600,700,1);

    @BeforeAll
    public static void setUpClass() {
        connectionPool = new ConnectionPool(USER, PASSWORD, URL);
        materialsMapper = new MaterialsMapper(connectionPool);

    }



    @Test
    public void testConnection() throws SQLException
    {
        Connection connection = connectionPool.getConnection();
        assertNotNull(connection);
        if (connection != null)
        {
            connection.close();
        }
    }
    @Test
    public void checkListIsNotEmpty() throws DatabaseException {
        BOMList.add(calculatorService.calculateSpaer());
        assertFalse(BOMList.isEmpty());
    }

}
