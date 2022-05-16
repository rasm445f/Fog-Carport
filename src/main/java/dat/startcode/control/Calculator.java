package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Calculator", value = "/Calculator")
public class Calculator extends HttpServlet {
    private HttpSession session;
    private ConnectionPool connectionPool;
    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        List<Object> carportAtributes = (List<Object>) session.getAttribute("carportAtributes");
        ServletContext context = getServletContext();
        int orderID = Integer.parseInt((String) context.getAttribute("order_id"));
        dat.startcode.model.services.Calculator calculator = new dat.startcode.model.services.Calculator(carportAtributes,orderID);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
