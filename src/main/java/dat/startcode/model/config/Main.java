package dat.startcode.model.config;

import dat.startcode.model.entities.ToolshedWidth;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.ToolshedWidthMapper;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        ToolshedWidthMapper toolshedWidthMapper = new ToolshedWidthMapper(connectionPool);
        ArrayList<ToolshedWidth> toolshedWidthList = toolshedWidthMapper.GetToolshedWidth();

        for (ToolshedWidth toolshedWidth : toolshedWidthList) {
            System.out.println(toolshedWidth.getToolshedWidth());
        }

    }
}
