package dat.startcode.control;

import dat.startcode.model.entities.CarportLength;
import dat.startcode.model.entities.CarportWidth;
import dat.startcode.model.entities.ToolshedLength;
import dat.startcode.model.entities.ToolshedWidth;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "createCarport", value = "/createCarport")
public class CreateCarport extends HttpServlet {
    HttpSession session;
    ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        connectionPool = new ConnectionPool();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();

       ToolshedWidthMapper toolshedWidthMapper = new ToolshedWidthMapper(connectionPool);
       ToolshedLengthMapper toolshedLengthMapper = new ToolshedLengthMapper(connectionPool);
       CarportWidthMapper carportWidthMapper = new CarportWidthMapper(connectionPool);
        CarportLengthMapper carportLengthMapper = new CarportLengthMapper(connectionPool);

       ArrayList<CarportWidth> carportWidthList = null;
       ArrayList<CarportLength> carportLengthList = null;
       ArrayList<ToolshedWidth> toolshedWidthList = null;
       ArrayList<ToolshedLength> toolshedLengthList = null;


       try{
           carportWidthList = carportWidthMapper.createCarportwidth();
           carportLengthList = carportLengthMapper.createCarportLength();
           toolshedWidthList = toolshedWidthMapper.GetToolshedWidth();
           toolshedLengthList = toolshedLengthMapper.GetToolshedLength();
       } catch (DatabaseException e) {
           e.printStackTrace();
       }

       session.setAttribute("carportWidthList",carportWidthList);
       session.setAttribute("carportLengthList",carportLengthList);
       session.setAttribute("toolshedWidthList",toolshedWidthList);
       session.setAttribute("toolshedLengthList",toolshedLengthList);
       request.getRequestDispatcher("createCarport.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        session = request.getSession();
    }
}