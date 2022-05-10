package dat.startcode.model.config;

import dat.startcode.model.entities.CarportLength;
import dat.startcode.model.entities.CarportWidth;
import dat.startcode.model.entities.Materials;
import dat.startcode.model.entities.ToolshedWidth;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();

        CarportWidthMapper carportWidthMapper = new CarportWidthMapper(connectionPool);

        ArrayList<CarportWidth> widthList = carportWidthMapper.createCarportwidth();

        for (CarportWidth carportWidth : widthList) {
            System.out.println(carportWidth.getCarportWidthID());
        }

    }
}
