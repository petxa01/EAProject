package EA;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.Client.*;
import static EA.Develop.*;
import static EA.Tools.*;
import static EA.Developer.*;
import static EA.Studio.*;
import static EA.Division.*;
import static EA.Franchise.*;
import static EA.Game.*;
import static EA.Sale.*;

public class DBtools {
    /**
     * @param table nombre de las tablas
     * @param field campo para comparar
     * @param value valor para comparar
     * @return devuelve los resultados en un arrayList de objetos es null si el result esta vacio
     */
    public static ArrayList<Object> Show(String table, String field, String value) {
        ArrayList<Object> objectList = new ArrayList();
        ResultSet res = query("Select * From ea." + table + " where " + field + "=" + value,true);
        boolean exist = false;
        table = table.toLowerCase();
        objectList = selectTable(table,objectList,res,exist);
        if (objectList != null) return objectList;
        return null;
    }

    public static ArrayList<Object> Show(String table) {
        ArrayList<Object> objectList = new ArrayList();
        ResultSet res = query("Select * From ea." + table,true);
        boolean exist = false;
        table = table.toLowerCase();
        objectList = selectTable(table,objectList,res,exist);
        if (objectList != null) return objectList;
        return null;
    }

    private static ArrayList<Object> selectTable(String table,ArrayList<Object> objectList, ResultSet res, boolean exist) {
        switch (table) { //tabla es siempre en minusculas
            case "clients":
                return selectClients(objectList, res, exist);

            case "develops":
                return selectDevelop(objectList, res, exist);

            case "developers":
                return selectDevelopers(objectList, res, exist);

            case "studio":
                return selectStudios(objectList, res, exist);

            case "divisions":
                return selectDivisions(objectList, res, exist);

            case "franchises":
                return selectFranchises(objectList, res, exist);

            case "games":
                return selectGames(objectList, res, exist);

            case "sales":
                return selectSales(objectList, res, exist);
        }
        return null;
    }

    /**
     *
     * @param id
     * @param table
     */
    private static void Delete(String id,String table){
        query("Delete from "+table+" where Id = "+id,false);

    }

}
