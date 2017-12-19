package EA;

import java.sql.ResultSet;
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
    public static ArrayList<Object> show(String table, String field, String value) {
        ArrayList<Object> objectList = new ArrayList();
        ResultSet res = query("Select * From ea." + table + " where " + field + "=" + value);
        boolean exist = false;
        table = table.toLowerCase();
        objectList = selectTable(table,res,exist);
        if (objectList != null) return objectList;
        return null;
    }
    /**
     * @param table name of the requested table
     * @return returns
     */
    public static ArrayList<Object> show(String table) {
        ArrayList<Object> objectList = new ArrayList();
        ResultSet res = query("Select * From ea." + table);
        boolean exist = false;
        table = table.toLowerCase();
        objectList = selectTable(table,res,exist);
        if (objectList != null) return objectList;
        return null;
    }


    /**
     *
     * @param table nombre de la tablas
     * @param res
     * @param exist
     * @return ArrayList con el resultado del select
     */
    private static ArrayList<Object> selectTable(String table, ResultSet res, boolean exist) {
        switch (table) { //tabla es siempre en minusculas
            case "clients":
                return selectClients(res, exist);

            case "develops":
                return selectDevelop(res, exist);

            case "developers":
                return selectDevelopers( res, exist);

            case "studio":
                return selectStudios( res, exist);

            case "divisions":
                return selectDivisions( res, exist);

            case "franchises":
                return selectFranchises(res, exist);

            case "games":
                return selectGames(res, exist);

            case "sales":
                return selectSales(res, exist);
        }
        return null;
    }


}
