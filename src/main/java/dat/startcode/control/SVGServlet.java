package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.services.SVG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SVGServlet", value = "/SVGServlet")
public class SVGServlet extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carportLength = 780;
        int carportWidth = 600;
        int toolshedLength = 210;
        int toolshedWidth = 600;

        SVG svg = new SVG(0, 0, "0 0 800 600", 100, 50);

        for (int x = 0; x < 14; x++) {
            svg.addRect(100 + 50 * x, 0, carportWidth, 4.5);
        }



        request.setAttribute("svgdrawing", svg.toString());

        request.getRequestDispatcher("SVGCarport.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
