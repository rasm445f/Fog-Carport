package dat.startcode.model.config;

import dat.startcode.model.entities.CarportLength;
import dat.startcode.model.entities.ToolshedWidth;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportLengthMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.ToolshedWidthMapper;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        ToolshedWidthMapper toolshedWidthMapper = new ToolshedWidthMapper(connectionPool);
        CarportLengthMapper carportLengthMapper = new CarportLengthMapper(connectionPool);
        ArrayList<CarportLength> carportLengthList = carportLengthMapper.createCarportLength();
        ArrayList<ToolshedWidth> toolshedWidthList = toolshedWidthMapper.GetToolshedWidth();



        for (CarportLength carportLength : carportLengthList) {
            System.out.println(carportLength.getCarportLengthCM());

        }

    }
}
