package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper implements IUserMapper
{
    ConnectionPool connectionPool;

    public UserMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    @Override
    public User login(String email, String password) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String city = rs.getString("city");
                    int zipcode = rs.getInt("zipcode");
                    int phone_number = rs.getInt("phone_number");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");

                    user = new User(email,password,role,balance,name,address,city,zipcode,phone_number);
                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    @Override
    public User createUser(String email, String password, String name, String address, String city, int zipcode, int phoneNumber) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into user (email,password,name,address,city,zipcode,phone_number) values (?,?,?,?,?,?,?)";


        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ps.setString(3,name);
                ps.setString(4,address);
                ps.setString(5,city);
                ps.setInt(6,zipcode);
                ps.setInt(7,phoneNumber);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {

                    user = new User(email,password,name,address,city,zipcode,phoneNumber);

                } else {
                    throw new DatabaseException("The user with email = " + email + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }


}
