package dat.startcode.model.persistence;

import dat.startcode.control.Calculator;
import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.entities.Materials;

import java.util.ArrayList;
import java.util.List;

public class CalculatorMapper {
    List<Object> carportAtributes;
    public CalculatorMapper(List<Object> carportAtributes){
        this.carportAtributes = carportAtributes;
    }
    int cwidth = (int) carportAtributes.get(0);
    int clength = (int) carportAtributes.get(1);
    String rooftype = (String) carportAtributes.get(2);

    MaterialsMapper materialsMapper;
    ArrayList<Materials> materialList = materialsMapper.CreateMaterials();
    ArrayList<BillOfMaterials> BOMList = new ArrayList<>();

    public void calculateEverything(){
        calculateUndersternBraederForBackAndFront();
        calculateSpaer();
    }
    public void calculateStolper(){

    }
    public void calculateUndersternBraederForBackAndFront(){

    }
    public void calculateSpaer(){

        int spaceBetween = 55;
        String prerequesitOne = "spærtræ ubh.";
        int prerequesitTwo = 600;
        int amountOfSpaer = (int) Math.ceil(clength/spaceBetween);
        for (Materials materials : materialList) {
            if(materials.getMaterialDescription() == prerequesitOne && materials.getMaterialLength() == prerequesitTwo){
                BillOfMaterials billOfMaterials = new BillOfMaterials(amountOfSpaer,materials.getMaterialID(),"Spær,monteres på rem");
                BOMList.add(billOfMaterials);
                break;
            }
        }

    }
}
