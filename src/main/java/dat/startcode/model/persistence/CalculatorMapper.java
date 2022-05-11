package dat.startcode.model.persistence;

import dat.startcode.control.Calculator;
import dat.startcode.model.entities.BillOfMaterials;
import dat.startcode.model.entities.Materials;

import java.util.ArrayList;
import java.util.List;

public class CalculatorMapper {
    List<Object> carportAttributes;
    public CalculatorMapper(List<Object> carportAttributes){
        this.carportAttributes = carportAttributes;
    }
    int cwidth = (int) carportAttributes.get(0);
    int clength = (int) carportAttributes.get(1);
    String rooftype = (String) carportAttributes.get(2);

    MaterialsMapper materialsMapper;
    ArrayList<Materials> materialList = materialsMapper.CreateMaterials();
    ArrayList<BillOfMaterials> BOMList = new ArrayList<>();

    public void calculateEverything(){
        calculateStolper();
        calculateUndersternBraederForBackAndFront();
        calculateUndersternbraederforSides();
        calculateOversternBraederForFront();
        calculateOversternbraederforSides();
        calculateSpaer();
        calculateVandbraetForSides();
        calculateVandbraetForFront();
        calculateRoofPlates();
    }
    public void calculateStolper(){
        int length = clength;
        int amountOfStolper = 1;
        int spaceFromBeginningToFirstStolpe;
        while(length > 310){
            amountOfStolper++;
            length = length - 310;
        }
        if(amountOfStolper == 1){
            amountOfStolper++;
            amountOfStolper = amountOfStolper * 2;
            spaceFromBeginningToFirstStolpe = 0;
        }
        else{
            amountOfStolper = amountOfStolper * 2;
            spaceFromBeginningToFirstStolpe = length/2;
        }
    }
    public void calculateUndersternBraederForBackAndFront(){
        int amountofUndersternBraeder = 1;
        int width = cwidth;
        while (width > 360){
            amountofUndersternBraeder++;
            width = width-360;
        }
        amountofUndersternBraeder = amountofUndersternBraeder * 2;
    }
    public void calculateUndersternbraederforSides(){
        int amountofUndersternSider = 1;
        int length = clength;
        while (length > 540){
            amountofUndersternSider++;
            length = length-540;
        }
        amountofUndersternSider = amountofUndersternSider * 2;
    }
    public void calculateOversternBraederForFront(){
        int amountofOversternFront = 1;
        int width = cwidth;
        while (width > 360){
            amountofOversternFront++;
            width = width-360;
        }
    }
    public void calculateOversternbraederforSides(){
        int amountofOversternSider = 1;
        int length = clength;
        while (length > 540){
            amountofOversternSider++;
            length = length-540;
        }
        amountofOversternSider = amountofOversternSider * 2;
    }
    public void calculateVandbraetForSides(){
        int amountofVandbraetSider = 1;
        int length = clength;
        while (length > 540){
            amountofVandbraetSider++;
            length = length-540;
        }
        amountofVandbraetSider = amountofVandbraetSider * 2;
    }
    public void calculateVandbraetForFront(){
        int amountofVandbraetFront = 1;
        int width = cwidth;
        while (width > 360){
            amountofVandbraetFront++;
            width = width-360;
        }
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
    public void calculateRoofPlates(){
        int amountOfRoofPlates = 1;
        int width = cwidth;
        int length = clength;
        int amountOfSmallRoofPlates = 0;
        while (width > 109){
            amountOfRoofPlates++;
            width = width-109;
        }
        if(length > 600){
            amountOfSmallRoofPlates = amountOfRoofPlates;
        }
    }

}
