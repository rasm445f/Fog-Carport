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

@WebServlet(name = "updateStatus", value = "/updateStatus")
public class UpdateStatus extends HttpServlet {
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
            request.getRequestDispatcher("/WEB-INF/carportInfoAdmin.jsp").forward(request, response);


        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        int order_id = Integer.parseInt(request.getParameter("update_status"));
        int order_status = Integer.parseInt(request.getParameter("order_status"));

        try {
            orderMapper.updateOrderStatus(order_id,order_status);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        doGet(request,response);
    }
}
