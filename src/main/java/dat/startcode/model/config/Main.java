package dat.startcode.model.config;

import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        System.out.println(orderMapper.calculateOrderPrice(2));

    }
}

