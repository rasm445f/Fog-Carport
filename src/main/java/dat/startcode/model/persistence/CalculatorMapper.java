package dat.startcode.model.persistence;

import dat.startcode.control.Calculator;
import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.entities.Materials;

import java.util.ArrayList;
import java.util.List;

public class CalculatorMapper {
    ConnectionPool connectionPool;
     MaterialsMapper materialsMapper;
     ArrayList<Materials> materialList;
     ArrayList<Materials> materialsUsedInCarport = new ArrayList<>();


    public void calculateEverything(){


    }

    public void calculateUndersternForOgBag(){


    }
    public int calculateSpærTilRem(int carportW, int carportL) {
        materialList = materialsMapper.CreateMaterials();

        int result = 0;
        int spaceBetween = 55;

        for (Materials materials : materialList) {
            if (materials.getMaterialID() == 8) {
                 {

                    result = (int) Math.ceil(carportL / spaceBetween);

                    materialsUsedInCarport.add(new Materials(8, materials.getMaterialDescription(), materials.getMaterialCategory(), materials.getMaterialUnit(), materials.getMaterialLength(), materials.getMaterialPrice()));

                    break;
                }
            }
        }
        return result;
    }


}

