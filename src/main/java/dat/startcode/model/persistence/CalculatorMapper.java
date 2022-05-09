package dat.startcode.model.persistence;

import dat.startcode.control.Calculator;
import dat.startcode.model.entities.BillOfMaterials;

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
    ArrayList<BillOfMaterials> BOMList = new ArrayList<>();
    public void calculateEverything(){
        calculateUndersternBraederForBackAndFront();
        calculateSpaer();
    }
    public void calculateUndersternBraederForBackAndFront(){

    }
    public void calculateSpaer(){
       int amountOfSpaer = (int) Math.ceil(clength/55);

    }
}
