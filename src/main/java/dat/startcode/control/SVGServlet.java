package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;
import dat.startcode.model.services.SVG;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "SVGServlet", value = "/SVGServlet")
public class SVGServlet extends HttpServlet {
    private HttpSession session;
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();
        User user = (User)session.getAttribute("user");
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        CarportMapper carportMapper = new CarportMapper(connectionPool);
        ArrayList<Carport> carportDataList = null;
        int userid = user.getUser_id();


        try {
            carportDataList = carportMapper.getCarportData(userid);

        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        session.setAttribute("carportDataList",carportDataList);
        request.getRequestDispatcher("/WEB-INF/carportInfoCustomer.jsp").forward(request, response);


    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String carportInfo = request.getParameter("svg");
            String[] strArray = carportInfo.split("#");

            int carportLength = Integer.parseInt(strArray[0]);
            int carportWidth = Integer.parseInt(strArray[1]);


            int toolshedLength = 210;
            int toolshedWidth = 600;
            int sp??rAmount = (int) Math.ceil((float) carportLength / 55) + 1;
            int stolpeAmount = (int) Math.ceil((float) carportLength / 310) + 1;

            int lengthOffset = (int) (carportLength * 0.2);
            int widthOffset = (int) (carportWidth * 0.1);


            SVG svg = new SVG(0, 0, "0 0 " + carportLength + " " + carportWidth, "60%", "60%");
            SVG carportSVG = new SVG(lengthOffset, widthOffset, "0 0 " + carportLength + " " + carportWidth, "80%", "80%");


            svg.addRect(0, 0, carportWidth + 200, carportLength + 200);
            carportSVG.addRect(0, 0, carportWidth, carportLength);  // rem
            carportSVG.addRect(0, carportWidth / 16, 4, carportLength);  // vandret sp??r ??verst
            carportSVG.addRect(0, carportWidth - carportWidth / 16, 4, carportLength);  // vandret sp??r nederst


            //lodret sp??r
            for (int x = 0; x < sp??rAmount; x++)
                if (x == 0)// f??rste sp??r
                {
                    carportSVG.addRect(0, 0, carportWidth, 4);
                } else if (x == sp??rAmount - 1)// sidste sp??r
                {
                    carportSVG.addRect(carportLength - 4, 0, carportWidth, 4);
                } else {
                    carportSVG.addRect(55 * x - 1, 0, carportWidth, 4);
                }


            //stopler ??verst
            int stolpeSt??relse = 10;
            for (int x = 0; x < stolpeAmount; x++) {
                if (x == 0) //hvis det er den f??rste
                {
                    carportSVG.addRect(0, carportWidth / 16 - 2, stolpeSt??relse, stolpeSt??relse);

                } else if (x == stolpeAmount - 1)//hvis det er den sidste
                {
                    carportSVG.addRect(carportLength - stolpeSt??relse, carportWidth / 16 - 2, stolpeSt??relse, stolpeSt??relse);
                } else if (carportLength > 300)//stolper i midten
                {
                    carportSVG.addRect(carportLength / 2, carportWidth / 16 - 2, stolpeSt??relse, stolpeSt??relse);
                }
            }
            //stolper neders
            for (int x = 0; x < stolpeAmount; x++) {
                if (x == 0) //hvis det er den f??rste
                {
                    carportSVG.addRect(0, carportWidth - carportWidth / 16 - 2, stolpeSt??relse, stolpeSt??relse);

                } else if (x == stolpeAmount - 1)//hvis det er den sidste
                {
                    carportSVG.addRect(carportLength - stolpeSt??relse, carportWidth - carportWidth / 16 - 2, stolpeSt??relse, stolpeSt??relse);
                } else if (carportLength > 300)//stolper i midten
                {
                    carportSVG.addRect(carportLength / 2, carportWidth - carportWidth / 16 - 2, stolpeSt??relse, stolpeSt??relse);
                }
            }


            int sp??rOffset = carportWidth - 70;

            //bottom arrow
            svg.addArrow(lengthOffset, carportWidth - widthOffset / 3, carportLength - 2, carportWidth - widthOffset / 3, carportLength - (carportLength - lengthOffset) / 2, carportWidth - widthOffset / 2, 0, "" + carportLength);
//
//            svg.addArrow(100,padding, 100+carportLength,padding,(carportLength)/2,padding,"200"); //arrow top
            svg.addArrow(lengthOffset / 3, widthOffset, lengthOffset / 3, carportWidth - widthOffset, lengthOffset / 3 - 5, carportWidth - (carportWidth - widthOffset) / 2, -90, "" + carportWidth); // arrow side
            svg.addArrow(lengthOffset / 2 + 20, widthOffset + carportWidth / 16, lengthOffset / 2 + 20, carportWidth - (widthOffset + carportWidth / 16) + widthOffset / 6, lengthOffset / 2 + 20, (carportWidth - (widthOffset + carportWidth / 16) + widthOffset / 6) / 2 + widthOffset, -90, "" + sp??rOffset); // inner arrow side
//
            carportSVG.addDashedLine(carportLength / 10, carportWidth / 16, carportLength - carportLength / 10, carportWidth - carportWidth / 16);
            carportSVG.addDashedLine(carportLength / 10, carportWidth - carportWidth / 16, carportLength - carportLength / 10, carportWidth / 16);

            //lodret sp??r arrows
//        for (int x = 0; x < sp??rAmount; x++)
//            if (x == 0)// f??rste sp??r
//            {
//                svg.addArrow(lengthOffset,);
//            }
//            else if (x == sp??rAmount-1)// sidste sp??r
//            {
//                carportSVG.addRect(carportLength-4,0,carportWidth,4);
//            }
//            else {
//                carportSVG.addRect(55 * x-1,0,carportWidth,4);}


            svg.addSvg(carportSVG);
            request.setAttribute("svgdrawing", svg.toString());

            request.getRequestDispatcher("/WEB-INF/SVGCarport.jsp").forward(request, response);
        }

}

