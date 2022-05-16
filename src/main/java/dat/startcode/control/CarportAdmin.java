package dat.startcode.control;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "carportAdmin", value = "/carportAdmin")
public class CarportAdmin extends HttpServlet {
    HttpSession session;
    ConnectionPool connectionPool;


    @Override
    public void init() throws ServletException {
        connectionPool = new ConnectionPool();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            connectionPool.getConnection();
            session = request.getSession();
            CarportMapper carportMapper = new CarportMapper(connectionPool);
            ArrayList<Carport> carportDataListAdmin = null;



            try {
                carportDataListAdmin = carportMapper.getCarportDataAdmin();

            } catch (DatabaseException e) {
                e.printStackTrace();
            }

            session.setAttribute("carportDataListAdmin",carportDataListAdmin);
            request.getRequestDispatcher("carportInfoAdmin.jsp").forward(request, response);


        } catch (SQLException e) {
            System.out.println(e);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
