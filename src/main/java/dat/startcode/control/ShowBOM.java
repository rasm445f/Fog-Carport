package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.persistence.BillOfMaterialsMapper;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowBom", value = "/ShowBom")
public class ShowBOM extends HttpServlet {
    private HttpSession session;
    private ConnectionPool connectionPool;
    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        ArrayList<BillOfMaterials> bomSpecification = new ArrayList<>();
        int bomID = 0;
        try {
             bomID = (int) context.getAttribute("bomID");
        }
        catch (NullPointerException e){
        }
        BillOfMaterialsMapper billOfMaterialsMapper = new BillOfMaterialsMapper(connectionPool);
        try {
            connectionPool.getConnection();
            session = request.getSession();
            bomSpecification = billOfMaterialsMapper.selectSpecificBOM(bomID);
            session.setAttribute("bomSpecification",bomSpecification);

        }
        catch (SQLException e){
            System.out.println("oh no");
        }
        request.getRequestDispatcher("/WEB-INF/showBOM.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bomID = Integer.parseInt(request.getParameter("bom"));
        ServletContext context = getServletContext();
        context.setAttribute("bomID",bomID);
        doGet(request,response);
    }
}
