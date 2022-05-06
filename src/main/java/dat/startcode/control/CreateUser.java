package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "createUser", urlPatterns = {"/createUser"})
public class CreateUser extends HttpServlet {

    private ConnectionPool connectionPool;
    private User user;
    private UserMapper userMapper;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("createUser.jsp").forward(request, response);
          
          
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        user = null;
        userMapper = new UserMapper(connectionPool);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String role = request.getParameter("role");
        int zipcode = Integer.parseInt(request.getParameter("zipcode"));
        int phone_number = Integer.parseInt(request.getParameter("phone_number"));

        try {
            Connection connection = connectionPool.getConnection();
            user = userMapper.createUser(email, password, name, address, city, zipcode, phone_number);
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            session.setAttribute("name", name);
            session.setAttribute("address", address);
            session.setAttribute("city", city);
            session.setAttribute("zipcode", zipcode);
            session.setAttribute("phone_number", phone_number);
            session.setAttribute("role",role);
            

            request.getRequestDispatcher("login.jsp").forward(request, response);
            connection.close();


        } catch (DatabaseException e) {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        catch (SQLException e){
            System.out.println(e);
        }


    }
}
