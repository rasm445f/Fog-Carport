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
        int carportLength = 300;
        int carportWidth = 200;
        int toolshedLength = 210;
        int toolshedWidth = 600;
        int spærAmount = (int) Math.ceil((float)carportLength/55)+1;
        int stolpeAmount = 3;

        SVG svg = new SVG(0, 0, "0 0 800 600", 100, 50);

        svg.addRect(100,0,carportWidth,carportLength);  // rem
        svg.addRect(100,carportWidth/16,4,carportLength);  // vandret spær øverst
        svg.addRect(100,carportWidth - carportWidth/16,4,carportLength);  // vandret spær nederst


        for (int x = 0; x < spærAmount; x++) {
            svg.addRect(100 + 50 * x, 0, carportWidth, 4);
        }

        //stopler øverst
        int stolpeStørelse = 10;
        for (int x = 0; x < stolpeAmount; x++) {
            svg.addRect(carportLength/stolpeAmount - stolpeStørelse/stolpeAmount + carportLength/stolpeAmount * x, carportWidth/16 - 2, stolpeStørelse, stolpeStørelse);
        }
        //stolper neders
        for (int x = 0; x < stolpeAmount; x++) {
            svg.addRect(carportLength/stolpeAmount - stolpeStørelse/stolpeAmount + carportLength/stolpeAmount * x, carportWidth - carportWidth/16 - 2, stolpeStørelse, stolpeStørelse);
        }

        request.setAttribute("svgdrawing", svg.toString());

        request.getRequestDispatcher("SVGCarport.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
