/*package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Order;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "orderlinje" , value = "/orderlinje")
public class OrderLinje extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
        String sqlorder = "SELECT * FROM fogcarport.order;";
        List<Order> orderList = new ArrayList<>();

        try {
            connectionPool.getConnection();
            try (PreparedStatement ps = connectionPool.getConnection().prepareStatement(sqlorder)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    //int orderID = rs.getInt("order_id");
                    int userID = rs.getInt("user_id");
                    Date orderDate = rs.getDate("order_date");
                    int orderPrice = rs.getInt("order_price");
                    int orderStatus = rs.getInt("order_status");
                    int bomID = rs.getInt("bom_id");
                    //List<Tops> toplist = (ArrayList<Tops>) context.getAttribute("toplist");
                    //List<Bottoms> bottomlist = (ArrayList<Bottoms>) context.getAttribute("bottomlist");

                    //Optional<Tops> topsOptional = toplist.stream().filter(item -> item.getTopID() == topID).findFirst();
                    // Tops top = topsOptional.orElseThrow(() -> new RuntimeException("Toppen ekistere ikke!") );


//                    Tops top = null;
//                    Bottoms bottom = null;
//                    for (int i = 0; i < toplist.size(); i++) {
//                        if (toplist.get(i).getTopID() == topID) {
//                            top = toplist.get(i);
//                        }
//
//                    }
//                    for (int i = 0; i < bottomlist.size(); i++) {
//                        if (bottomlist.get(i).getBottomID() == bottomID) {
//                            bottom = bottomlist.get(i);
//                        }
//
//                    }


                    Order order = new Order(userID, orderDate, orderPrice, orderStatus, bomID);
                    orderList.add(order);
                }
                session.setAttribute("ordreList", orderList);
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            }
        } catch (SQLException e) {

        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
*/