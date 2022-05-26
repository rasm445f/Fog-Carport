package dat.startcode.model.services;

import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.entities.Materials;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.MaterialsMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorService {
    private ConnectionPool connectionPool;
    private int orderID;
    private int cwidth;
    private int clength;
    private int bom_id;
    private String rooftype;
    ArrayList<BillOfMaterials> BOMList = new ArrayList<>();
    ArrayList<Materials> materialList;
    MaterialsMapper materialsMapper;

    public CalculatorService(ConnectionPool connectionPool, int cwidth, int clength, int orderID) {
        this.connectionPool = connectionPool;
        this.materialsMapper = new MaterialsMapper(connectionPool);
        this.materialList = materialsMapper.CreateMaterials();
        this.cwidth = cwidth;
        this.clength = clength;
        this.orderID = orderID;
        this.bom_id = orderID;
    }

    public ArrayList<BillOfMaterials> calculateEverything() throws DatabaseException {
        BOMList.add(calculateStolper());
        BOMList.add(calculateUndersternBraederForBackAndFront());
        BOMList.add(calculateUndersternbraederforSides());
        BOMList.add(calculateOversternBraederForFront());
        BOMList.add(calculateOversternbraederforSides());
        BOMList.add(calculateVandbraetForSides());
        BOMList.add(calculateVandbraetForFront());
        BOMList.add(calculateSpaer());
        BOMList.add(calculateRoofPlates());
        if(clength > 600) {
            BOMList.add(calculateRoofPlatesSmall());
        }
        return BOMList;
    }

    public int getNextBOMID() throws DatabaseException{

        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "SELECT MAX(bom_id) FROM bill_of_materials";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    bom_id = rs.getInt("MAX(order_id)");
                    this.bom_id = bom_id++;

                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Newest order_id could not be found");
        }
        return bom_id;
    }



    public BillOfMaterials calculateStolper() throws DatabaseException {

        String prerequesitOne = "97x97 mm. trykimp. Stolpe";
        int length = clength;
        int materialLength = 300;
        int amountOfStolper = 2;
        int spaceFromBeginningToFirstStolpe;
        while (length > 310) {
            amountOfStolper++;
            length = length - 310;
        }
            amountOfStolper = amountOfStolper * 2;
            spaceFromBeginningToFirstStolpe = length / 2;
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription().equals(prerequesitOne) && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountOfStolper, materials.getMaterialID(), "Stolper nedgraves 90cm. i jord",orderID);
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateUndersternBraederForBackAndFront() throws DatabaseException {

        String prerequesitOne = "25x200 mm. trykimp. Brædt";
        int amountofUndersternBraeder = 1;
        int width = cwidth;
        int materialLength = 360;
        while (width > 360) {
            amountofUndersternBraeder++;
            width = width - 360;
        }
        amountofUndersternBraeder = amountofUndersternBraeder * 2;
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription().equals(prerequesitOne) && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountofUndersternBraeder, materials.getMaterialID(), "understernbrædder til for og bag ende",orderID);
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateUndersternbraederforSides() throws DatabaseException {

        String prerequesitOne = "25x200 mm. trykimp. Brædt";
        int amountofUndersternSider = 1;
        int materialLength = 540;
        int length = clength;
        while (length > 540) {
            amountofUndersternSider++;
            length = length - 540;
        }
        amountofUndersternSider = amountofUndersternSider * 2;
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription().equals(prerequesitOne) && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountofUndersternSider, materials.getMaterialID(), "understernbrædder til siderne",orderID);
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateOversternBraederForFront() throws DatabaseException {

        String prerequesitOne = "25x125 mm. trykimp. Brædt";
        int amountofOversternFront = 1;
        int width = cwidth;
        int materialLength = 360;
        while (width > 360) {
            amountofOversternFront++;
            width = width - 360;
        }
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription().equals(prerequesitOne)  && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountofOversternFront, materials.getMaterialID(), "toversternsbrædder til forende",orderID);
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateOversternbraederforSides() throws DatabaseException {

        String prerequesitOne = "25x125 mm. trykimp. Brædt";
        int amountofOversternSider = 1;
        int materialLength = 540;
        int length = clength;
        while (length > 540) {
            amountofOversternSider++;
            length = length - 540;
        }
        amountofOversternSider = amountofOversternSider * 2;
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription().equals(prerequesitOne) && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountofOversternSider, materials.getMaterialID(), "oversternbrædder til siderne",orderID);
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateVandbraetForSides() throws DatabaseException {

        String prerequesitOne = "19x100 mm. trykimp. Brædt";
        int amountofVandbraetSider = 1;
        int materialLength = 540;
        int length = clength;
        while (length > 540) {
            amountofVandbraetSider++;
            length = length - 540;
        }
        amountofVandbraetSider = amountofVandbraetSider * 2;
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription().equals(prerequesitOne) && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountofVandbraetSider, materials.getMaterialID(), "vandbræt på stern i sider",orderID);
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateVandbraetForFront() throws DatabaseException {

        String prerequesitOne = "19x100 mm. trykimp. Brædt";
        int amountofVandbraetFront = 1;
        int materialLength = 360;
        int width = cwidth;
        while (width > 360) {
            amountofVandbraetFront++;
            width = width - 360;
        }
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription().equals(prerequesitOne) && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountofVandbraetFront, materials.getMaterialID(), "vandbræt på stern i forende",orderID);
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateSpaer() throws DatabaseException {

        int spaceBetween = 55;
        String prerequesitOne = "45x195 mm. spærtræ ubh.";
        int materialLength = 600;
        int amountOfSpaer = (int) Math.ceil(clength / spaceBetween);
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription().equals(prerequesitOne) && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountOfSpaer, materials.getMaterialID(), "Spær,monteres på rem",orderID);
                return billOfMaterials;
            }
        }

        return null;
    }

    public BillOfMaterials calculateRoofPlates() throws DatabaseException {

        int amountOfRoofPlates = 1;
        String prerequesitOne = "Plastmo Ecolite blåtonet";
        int materialLength = 600;
        int width = cwidth;
        while (width > 109) {
            amountOfRoofPlates++;
            width = width - 109;
        }
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription().equals(prerequesitOne) && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountOfRoofPlates, materials.getMaterialID(), "tagplader monteres på spær",orderID);
                return billOfMaterials;
            }
        }
        return null;
    }
    public BillOfMaterials calculateRoofPlatesSmall() throws DatabaseException {

        int amountOfRoofPlates = 1;
        String prerequesitOne = "Plastmo Ecolite blåtonet";
        int materialLength = 360;
        int length = clength;
        int width = cwidth;
        if(length > 600) {
            while (width > 109) {
                amountOfRoofPlates++;
                width = width - 109;
            }
            for (Materials materials : materialList) {
                if (materials.getMaterialDescription().equals(prerequesitOne) && materials.getMaterialLength() == materialLength) {
                    BillOfMaterials billOfMaterials = new BillOfMaterials(bom_id,amountOfRoofPlates, materials.getMaterialID(), "tagplader monteres på spær",orderID);
                    return billOfMaterials;
                }
            }
        }
        return null;
    }
}

