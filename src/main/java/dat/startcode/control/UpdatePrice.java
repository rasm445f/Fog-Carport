package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Carport;
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

@WebServlet(name = "updatePrice", value = "/updatePrice")
public class UpdatePrice extends HttpServlet {
    private HttpSession session;
    private ConnectionPool connectionPool;


    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();
        CarportMapper carportMapper = new CarportMapper(connectionPool);
        ArrayList<Carport> carportDataListAdmin = null;


        try {
            carportDataListAdmin = carportMapper.getCarportDataAdmin();

        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        session.setAttribute("carportDataListAdmin",carportDataListAdmin);
        request.getRequestDispatcher("/WEB-INF/carportInfoAdmin.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int order_price = Integer.parseInt(request.getParameter("order_price"));

        try {
            orderMapper.updateOrderPrice(order_id,order_price);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        doGet(request,response);

    }
}
