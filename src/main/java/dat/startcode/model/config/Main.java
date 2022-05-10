package dat.startcode.model.config;

import dat.startcode.model.entities.CarportWidth;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();

        CarportWidthMapper carportWidthMapper = new CarportWidthMapper(connectionPool);

        ArrayList<CarportWidth> widthList = carportWidthMapper.getCarportWidth();

        for (CarportWidth carportWidth : widthList) {
            System.out.println(carportWidth.getCarportWidthID());
            System.out.println(carportWidth.getCarportWidth());
        }

    }
}
