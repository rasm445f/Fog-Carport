package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.entities.Carport;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.BillOfMaterialsMapper;
import dat.startcode.model.persistence.CarportMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.CalculatorService;

import javax.naming.Context;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "calculator", value = "/calculator")
public class Calculator extends HttpServlet {
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
            request.getRequestDispatcher("bomlist.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        int carport_length = Integer.parseInt(request.getParameter("carportLengthCM"));
        int carport_width = Integer.parseInt(request.getParameter("carportWidthCM"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        CalculatorService calculatorService = new CalculatorService(connectionPool,carport_width,carport_length,order_id);
        BillOfMaterialsMapper billOfMaterialsMapper = new BillOfMaterialsMapper(connectionPool);
        try {
            ArrayList<BillOfMaterials> bomList = calculatorService.calculateEverything();
            billOfMaterialsMapper.createBOM(bomList);
           int bom_id = bomList.get(0).getBom_id();
            context.setAttribute("bomID",bom_id);

        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        doGet(request,response);


    }
}
