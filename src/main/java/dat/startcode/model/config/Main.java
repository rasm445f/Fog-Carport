package dat.startcode.model.config;

import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        List<Object> objects = new ArrayList<>();
        int one = 600;
        int two = 780;
        /*String three = "yes";
        objects.add(one);
        objects.add(two);
        objects.add(three);
        Calculator calculator = new Calculator(objects);
        ArrayList<BillOfMaterials> Bomlist = calculator.calculateEverything();
        System.out.println(Bomlist.size());
        for (BillOfMaterials bill : Bomlist){
            System.out.println(bill.getMaterialGuidance()); */

        CarportMapper carportMapper = new CarportMapper(connectionPool);
        ArrayList<Carport> listAdmin = carportMapper.getCarportDataAdmin();
        for (Carport carport : listAdmin) {
            System.out.println(carport.getCustomerName());
        }
        }
    }

