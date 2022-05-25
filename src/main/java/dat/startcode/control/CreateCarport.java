package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;
import dat.startcode.model.services.CalculatorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "createCarport", value = "/createCarport")
public class CreateCarport extends HttpServlet {
    private HttpSession session;
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {

            Connection connection = connectionPool.getConnection();
            session = request.getSession();
            ToolshedWidthMapper toolshedWidthMapper = new ToolshedWidthMapper(connectionPool);
            ToolshedLengthMapper toolshedLengthMapper = new ToolshedLengthMapper(connectionPool);
            CarportWidthMapper carportWidthMapper = new CarportWidthMapper(connectionPool);
            CarportLengthMapper carportLengthMapper = new CarportLengthMapper(connectionPool);
            RooftypeMapper rooftypeMapper = new RooftypeMapper(connectionPool);


            ArrayList<CarportWidth> carportWidthList = null;
            ArrayList<CarportLength> carportLengthList = null;
            ArrayList<ToolshedWidth> toolshedWidthList = null;
            ArrayList<ToolshedLength> toolshedLengthList = null;
            ArrayList<Rooftype> rooftypeList = null;


            try {

                carportWidthList = carportWidthMapper.getCarportWidth();
                carportLengthList = carportLengthMapper.createCarportLength();
                toolshedWidthList = toolshedWidthMapper.GetToolshedWidth();
                toolshedLengthList = toolshedLengthMapper.GetToolshedLength();
                rooftypeList = rooftypeMapper.getRooftype();

            } catch (DatabaseException e) {
                e.printStackTrace();
            }

            session.setAttribute("carportWidthList", carportWidthList);
            session.setAttribute("carportLengthList", carportLengthList);
            session.setAttribute("toolshedWidthList", toolshedWidthList);
            session.setAttribute("toolshedLengthList", toolshedLengthList);
            session.setAttribute("rooftypeList", rooftypeList);
            request.getRequestDispatcher("/WEB-INF/createCarport.jsp").forward(request, response);
            connection.close();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        CarportMapper carportMapper = new CarportMapper(connectionPool);
        ToolshedMapper toolshedMapper = new ToolshedMapper(connectionPool);
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        CarportWidthMapper carportWidthMapper = new CarportWidthMapper(connectionPool);
        CarportLengthMapper carportLengthMapper = new CarportLengthMapper(connectionPool);
        session = request.getSession();
        int carport_width_id = Integer.parseInt(request.getParameter("CarportWidthID"));
        int carport_length_id = Integer.parseInt(request.getParameter("CarportLengthID"));
        int rooftype_id = Integer.parseInt(request.getParameter("RooftypeID"));
        int toolshed_width_id = 0;
        String lackofToolshedWidth_id;
        try{
            toolshed_width_id = Integer.parseInt(request.getParameter("ToolshedWidthID"));
        }
        catch (NumberFormatException e){
            lackofToolshedWidth_id = request.getParameter("ToolshedWidthID");
        }
        String lackofToolshedLength_id;
        int toolshed_length_id = 0;
        try{
             toolshed_length_id = Integer.parseInt(request.getParameter("ToolshedLengthID"));
        }
        catch (NumberFormatException e){
            lackofToolshedLength_id = request.getParameter("ToolshedWidthID");
        }
        CarportWidth carportWidth = carportWidthMapper.getSpecificCarportwidth(carport_width_id);
        CarportLength carportLength = carportLengthMapper.getSpecificCarportLength(carport_length_id);
        BillOfMaterialsMapper billOfMaterialsMapper = new BillOfMaterialsMapper(connectionPool);


        try {

            Connection connection = connectionPool.getConnection();
            User user = (User)session.getAttribute("user");
            orderMapper.createOrder(user.getUser_id(), 1);
            Order order = orderMapper.getNewestOrderID();
            int order_id = order.getOrder_id();
            CalculatorService calculatorService = new CalculatorService(connectionPool,carportWidth.getCarportWidth(),carportLength.getCarportLength(),order_id);
            ArrayList<BillOfMaterials> bomList = calculatorService.calculateEverything();
            billOfMaterialsMapper.createBOM(bomList);
            int order_price =orderMapper.calculateOrderPrice(order_id);
            orderMapper.updateOrderPrice(order_id,order_price);
            session.setAttribute("order_id",order_id);
            session.setAttribute("currentCarportWidth",carportWidth);
            session.setAttribute("currentCarportLength",carportLength);
            // TODO: 12-05-2022: make it so rooftypes actually gets inserted here;
            if(toolshed_width_id != 0 && toolshed_length_id != 0){
                toolshedMapper.insertToolshed(toolshed_width_id,toolshed_length_id);
            }
            carportMapper.createCarport(carport_width_id,carport_length_id,rooftype_id,order_id);



        }
        catch (SQLException e){

            } catch (DatabaseException e) {
            e.printStackTrace();
        }
            request.getRequestDispatcher("requestConfirmation.jsp").forward(request,response);

    }

}
