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
        ArrayList<BillOfMaterials> bomList = new ArrayList<>();
        try {
             bomList = (ArrayList<BillOfMaterials>) context.getAttribute("bomList");
        }
        catch (NullPointerException e){
        }
        BillOfMaterialsMapper billOfMaterialsMapper = new BillOfMaterialsMapper(connectionPool);
        try {
            connectionPool.getConnection();
            session = request.getSession();
            bomSpecification = billOfMaterialsMapper.selectSpecificBOM(bomList.get(0).getBom_id());
            session.setAttribute("bomSpecification",bomSpecification);

        }
        catch (SQLException e){
            System.out.println("oh no");
        }
        request.getRequestDispatcher("showBOM.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
