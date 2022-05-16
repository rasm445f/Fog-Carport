package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
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
    private HttpSession session;
    private ConnectionPool connectionPool;


    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();

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
        response.setContentType("text/html");
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        session = request.getSession();
        String order_id_String = request.getParameter("order_id");
        String order_price_String = request.getParameter("order_price");
        String order_status_String = request.getParameter("order_status");
        try {


        if(order_id_String != null|order_price_String != null|order_status_String != null) {
            int order_id = Integer.parseInt(order_id_String);
            int order_price = Integer.parseInt(order_price_String);
            int order_status = Integer.parseInt(order_status_String);
            orderMapper.updateOrderPrice(order_id,order_price);
            orderMapper.updateOrderStatus(order_id,order_status);
        }

        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        doGet(request,response);
    }
}

