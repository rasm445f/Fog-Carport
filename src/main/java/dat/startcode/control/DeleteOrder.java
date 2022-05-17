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

@WebServlet(name = "DeleteOrder", value = "/DeleteOrder")
public class DeleteOrder extends HttpServlet {
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
            User user = (User)session.getAttribute("user");
            OrderMapper orderMapper = new OrderMapper(connectionPool);
            CarportMapper carportMapper = new CarportMapper(connectionPool);
            ArrayList<Carport> carportDataList = null;



            try {
                int order_id = orderMapper.getOrderIDFromUserID(user.getUser_id());
                carportDataList = carportMapper.getCarportData(order_id);

            } catch (DatabaseException e) {
                e.printStackTrace();
            }

            session.setAttribute("carportDataList",carportDataList);
            request.getRequestDispatcher("carportInfoCustomer.jsp").forward(request, response);


        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderMapper orderMapper = new OrderMapper(connectionPool);
        User user = (User)session.getAttribute("user");
        try {
            int order_id = orderMapper.getOrderIDFromUserID(user.getUser_id());
            orderMapper.deleteOrder(order_id);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("carportInfoCustomer.jsp").forward(request, response);

    }
}
