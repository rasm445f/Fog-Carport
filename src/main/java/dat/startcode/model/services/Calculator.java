package dat.startcode.model.services;

import dat.startcode.model.entities.Materials;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.MaterialsMapper;

import java.util.ArrayList;


public class Calculator {

    MaterialsMapper materialsMapper;
    ArrayList<Materials> materialList = materialsMapper.CreateMaterials();
    ArrayList<Materials> materialsUsedInCarport = new ArrayList<>();


    public int calculateSpær(int carportWidth, int carportLength){

        int result = 0;
        int spaceBetween = 55;
        for (Materials materials : materialList) {
            if(materials.getMaterialID()==8){
                if(carportWidth <= materials.getMaterialLength()){

                    result = carportLength/spaceBetween;

                    materialsUsedInCarport.add(new Materials(materials.getMaterialID(),materials.getMaterialDescription(),materials.getMaterialCategory(),materials.getMaterialUnit(),materials.getMaterialLength(),materials.getMaterialPrice()));
                }
            }
            
        }
        return result;

    }
}
