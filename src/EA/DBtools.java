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
<<<<<<< HEAD
     * @param table Table name
     * @param field Field name
     * @param value Value to compare with the field
     * @return ArrayList of the objects, returns null if empty
     */
    public static ArrayList<Object> show(String table, String field, String value) {
        ArrayList<Object> objectList;
        ResultSet res = sqlStmt("Select * From ea." + table + " where " + field + "=" + value,true);
=======
     * @param table nombre de las tablas
     * @param condition condition of the tables
     * @return devuelve los resultados en un arrayList de objetos es null si el result esta vacio
     */
    public static ArrayList<Object> show(String table, String condition) {
        ArrayList<Object> objectList = new ArrayList();
        ResultSet res = query("Select * From ea." + table + " where " +condition,true);
>>>>>>> 7dc6bf6c75669f96d732adfbb45910defcb11f9f
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
        ArrayList<Object> objectList;
        ResultSet res = sqlStmt("Select * From ea." + table,true);
        boolean exist = false;
        table = table.toLowerCase();
        objectList = selectTable(table,res,exist);
        if (objectList != null) return objectList;
        return null;
    }


    /**
     *
     * @param table Table name
     * @param res
     * @param exist
     * @return ArrayList with the result of the query
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

    /**
     *
     * @param table Table name
     * @param columnName Column name
     * @param value New value
     * @param condition WHERE condition
     */
    private static void update(String table,String columnName,String value,String condition){
        sqlStmt("UPDATE "+table+" SET "+columnName+" = "+value+" WHERE "+condition,false);
    }

    /**
     *
     * @param id
     * @param table
     */
    private static void delete(String id,String table){
        sqlStmt("Delete from "+table+" where Id = "+id,false);
    }

}
