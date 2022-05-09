package dat.startcode.model.config;

import dat.startcode.model.entities.CarportLength;
import dat.startcode.model.entities.Materials;
import dat.startcode.model.entities.ToolshedWidth;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportLengthMapper;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.MaterialsMapper;
import dat.startcode.model.persistence.ToolshedWidthMapper;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();

        MaterialsMapper materialsMapper = new MaterialsMapper(connectionPool);


        ArrayList<Materials> materialList = materialsMapper.createMaterials();


        for (Materials materials : materialList) {
            System.out.println(materials.getMaterialLength());

        }

    }
}
