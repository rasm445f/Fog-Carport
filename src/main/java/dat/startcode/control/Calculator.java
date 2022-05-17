package dat.startcode.control;

import dat.startcode.model.entities.CarportLength;
import dat.startcode.model.entities.CarportWidth;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Calculator", value = "/Calculator")
public class Calculator extends HttpServlet {
    HttpSession session;
    ConnectionPool connectionPool;
    @Override
    public void init() throws ServletException {
        connectionPool = new ConnectionPool();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        int orderID = Integer.parseInt((String) session.getAttribute("order_id"));
        CarportLength carportLength = (CarportLength) session.getAttribute("currentCarportLength");
        CarportWidth carportWidth = (CarportWidth) session.getAttribute("currentCarportWidth");
        List<Object> carportAttributes = new ArrayList<>();
        carportAttributes.add(carportWidth.getCarportWidth());
        carportAttributes.add(carportLength.getCarportLength());
        String roofname = "Plasttrapezplader";
        carportAttributes.add(roofname);
        dat.startcode.model.services.Calculator calculator = new dat.startcode.model.services.Calculator(carportAttributes,orderID);
        calculator.calculateEverything();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
