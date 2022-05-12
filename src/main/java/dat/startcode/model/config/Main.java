package dat.startcode.model.config;

import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.entities.CarportLength;
import dat.startcode.model.entities.Materials;
import dat.startcode.model.entities.ToolshedWidth;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportLengthMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.MaterialsMapper;
import dat.startcode.model.persistence.ToolshedWidthMapper;
import dat.startcode.model.services.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        List<Object> objects = new ArrayList<>();
        int one = 600;
        int two = 780;
        String three = "yes";
        objects.add(one);
        objects.add(two);
        objects.add(three);
        Calculator calculator = new Calculator(objects);
        ArrayList<BillOfMaterials> Bomlist = calculator.calculateEverything();
        System.out.println(Bomlist.size());
        System.out.println(Bomlist.get(0).getMaterialAmount());
    }
}
