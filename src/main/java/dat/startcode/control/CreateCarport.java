package dat.startcode.control;

import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        try {
            ServletContext context =getServletContext();


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

                carportWidthList = carportWidthMapper.createCarportwidth();
                carportLengthList = carportLengthMapper.createCarportLength();
                toolshedWidthList = toolshedWidthMapper.GetToolshedWidth();
                toolshedLengthList = toolshedLengthMapper.GetToolshedLength();
                rooftypeList = rooftypeMapper.getRooftype();

            } catch (DatabaseException e) {
                e.printStackTrace();
            }

            context.setAttribute("carportWidthList", carportWidthList);
            context.setAttribute("carportLengthList", carportLengthList);
            context.setAttribute("toolshedWidthList", toolshedWidthList);
            context.setAttribute("toolshedLengthList", toolshedLengthList);
            context.setAttribute("rooftypeList", rooftypeList);
            request.getRequestDispatcher("createCarport.jsp").forward(request, response);
            connection.close();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            ServletContext context =getServletContext();
            Connection connection = connectionPool.getConnection();
            session = request.getSession();
            List<Object> carportAttributes = new ArrayList<>();
            int cwidth = Integer.parseInt(request.getParameter("carport_width"));
            carportAttributes.add(cwidth);
            int clength = Integer.parseInt(request.getParameter("carport_length"));
            carportAttributes.add(clength);
            String rooftype = request.getParameter("rooftype");
            carportAttributes.add(rooftype);
            String toolshedWidth = request.getParameter("toolshed_width");
            String[] list;
            if (toolshedWidth != "I don't want a toolshed") {
                list = toolshedWidth.split(" ");
                carportAttributes.add(list[0]);
            } else {
                carportAttributes.add(toolshedWidth);
            }
            String toolshedLength = request.getParameter("toolshed_length");
            if (toolshedLength != "I don't want a toolshed") {
                list = toolshedLength.split(" ");
                carportAttributes.add(list[0]);
            } else {
                carportAttributes.add(toolshedLength);
            }
            context.setAttribute("carportAttributes", carportAttributes);
            request.getRequestDispatcher("requestConfirmation.jsp").forward(request,response);
            connection.close();
        }
        catch (SQLException e){

        }
    }

    }
