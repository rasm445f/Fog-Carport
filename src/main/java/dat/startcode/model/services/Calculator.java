package dat.startcode.model.services;

import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.entities.Materials;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.MaterialsMapper;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    List<Object> carportAttributes;

    public Calculator(List<Object> carportAttributes) {
        this.carportAttributes = carportAttributes;
        cwidth = (int) carportAttributes.get(0);
        clength = (int) carportAttributes.get(1);
        rooftype = (String) carportAttributes.get(2);
    }
    ConnectionPool connectionPool = new ConnectionPool();
    int cwidth;
    int clength;
    String rooftype;

    MaterialsMapper materialsMapper = new MaterialsMapper(connectionPool);
    ArrayList<Materials> materialList = materialsMapper.CreateMaterials();
    ArrayList<BillOfMaterials> BOMList = new ArrayList<>();

    public ArrayList<BillOfMaterials> calculateEverything() {
        BOMList.add(calculateStolper());
        BOMList.add(calculateUndersternBraederForBackAndFront());
        BOMList.add(calculateUndersternbraederforSides());
        BOMList.add(calculateOversternBraederForFront());
        BOMList.add(calculateOversternbraederforSides());
        BOMList.add(calculateVandbraetForSides());
        BOMList.add(calculateVandbraetForFront());
        BOMList.add(calculateSpaer());
        BOMList.add(calculateRoofPlates());
        BOMList.add(calculateRoofPlatesSmall());
        return BOMList;
    }

    public BillOfMaterials calculateStolper() {
        String prerequesitOne = "97x97mm. trykimp. Stolpe";
        int length = clength;
        int materialLength = 300;
        int amountOfStolper = 1;
        int spaceFromBeginningToFirstStolpe;
        while (length > 310) {
            amountOfStolper++;
            length = length - 310;
        }
        if (amountOfStolper == 1) {
            amountOfStolper++;
            amountOfStolper = amountOfStolper * 2;
            spaceFromBeginningToFirstStolpe = 0;
        } else {
            amountOfStolper = amountOfStolper * 2;
            spaceFromBeginningToFirstStolpe = length / 2;
        }
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountOfStolper, materials.getMaterialID(), "Stolper nedgraves 90cm. i jord");
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateUndersternBraederForBackAndFront() {
        String prerequesitOne = "25x200mm. trykimp. Brædt";
        int amountofUndersternBraeder = 1;
        int width = cwidth;
        int materialLength = 360;
        while (width > 360) {
            amountofUndersternBraeder++;
            width = width - 360;
        }
        amountofUndersternBraeder = amountofUndersternBraeder * 2;
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountofUndersternBraeder, materials.getMaterialID(), "understernbrædder til for og bag ende");
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateUndersternbraederforSides() {
        String prerequesitOne = "25x200mm. trykimp. Brædt";
        int amountofUndersternSider = 1;
        int materialLength = 540;
        int length = clength;
        while (length > 540) {
            amountofUndersternSider++;
            length = length - 540;
        }
        amountofUndersternSider = amountofUndersternSider * 2;
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountofUndersternSider, materials.getMaterialID(), "understernbrædder til siderne");
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateOversternBraederForFront() {
        String prerequesitOne = "25x125mm. trykimp. Brædt";
        int amountofOversternFront = 1;
        int width = cwidth;
        int materialLength = 600;
        while (width > 360) {
            amountofOversternFront++;
            width = width - 360;
        }
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountofOversternFront, materials.getMaterialID(), "toversternsbrædder til forende");
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateOversternbraederforSides() {
        String prerequesitOne = "25x125mm. trykimp. Brædt";
        int amountofOversternSider = 1;
        int materialLength = 540;
        int length = clength;
        while (length > 540) {
            amountofOversternSider++;
            length = length - 540;
        }
        amountofOversternSider = amountofOversternSider * 2;
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountofOversternSider, materials.getMaterialID(), "oversternbrædder til siderne");
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateVandbraetForSides() {
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
            if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountofVandbraetSider, materials.getMaterialID(), "vandbræt på stern i sider");
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateVandbraetForFront() {
        String prerequesitOne = "19x100 mm. trykimp. Brædt";
        int amountofVandbraetFront = 1;
        int materialLength = 360;
        int width = cwidth;
        while (width > 360) {
            amountofVandbraetFront++;
            width = width - 360;
        }
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountofVandbraetFront, materials.getMaterialID(), "vandbræt på stern i forende");
                return billOfMaterials;
            }
        }
        return null;
    }

    public BillOfMaterials calculateSpaer() {

        int spaceBetween = 55;
        String prerequesitOne = "45x195mm. spærtræ ubh.";
        int materialLength = 600;
        int amountOfSpaer = (int) Math.ceil(clength / spaceBetween);
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountOfSpaer, materials.getMaterialID(), "Spær,monteres på rem");
                return billOfMaterials;
            }
        }

        return null;
    }

    public BillOfMaterials calculateRoofPlates() {
        int amountOfRoofPlates = 1;
        String prerequesitOne = "Plastmo Ecolite blåtonet";
        int materialLength = 600;
        int width = cwidth;
        while (width > 109) {
            amountOfRoofPlates++;
            width = width - 109;
        }
        for (Materials materials : materialList) {
            if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountOfRoofPlates, materials.getMaterialID(), "tagplader monteres på spær");
                return billOfMaterials;
            }
        }
        return null;
    }
    public BillOfMaterials calculateRoofPlatesSmall() {
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
                if (materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == materialLength) {
                    BillOfMaterials billOfMaterials = new BillOfMaterials(amountOfRoofPlates, materials.getMaterialID(), "tagplader monteres på spær");
                    return billOfMaterials;
                }
            }
        }
        return null;
    }
}

