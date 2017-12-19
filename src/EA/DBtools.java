package EA;

import java.sql.ResultSet;
import java.util.ArrayList;

import static EA.Client.selectClients;
import static EA.Develop.selectDevelop;
import static EA.Developer.selectDevelopers;
import static EA.Division.selectDivisions;
import static EA.Franchise.selectFranchises;
import static EA.Game.selectGames;
import static EA.Sale.selectSales;
import static EA.Studio.selectStudios;
import static EA.Tools.sqlStmt;

public class DBtools {
    /**
     * @param table     Table name
     * @param condition The condition to meet
     * @return ArrayList of the objects, returns null if empty
     */
    public static ArrayList<Object> select(String table, String condition) {
        ArrayList<Object> objectList;
        ResultSet res = sqlStmt("Select * From ea." + table + " where " + condition, true);
        boolean exist = false;
        table = table.toLowerCase();
        objectList = selectTable(table, res, exist);
        if (objectList != null) return objectList;
        return null;
    }

    /**
     * @param table name of the requested table
     * @return returns
     */
    public static ArrayList<Object> select(String table) {
        ArrayList<Object> objectList;
        ResultSet res = sqlStmt("Select * From ea." + table, true);
        boolean exist = false;
        table = table.toLowerCase();
        objectList = selectTable(table, res, exist);
        if (objectList != null) return objectList;
        return null;
    }


    /**
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
                return selectDevelopers(res, exist);

            case "studio":
                return selectStudios(res, exist);

            case "divisions":
                return selectDivisions(res, exist);

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
     * @param table      Table name
     * @param columnName Column name
     * @param value      New value
     * @param condition  WHERE condition
     */
    private static void update(String table, String columnName, String value, String condition) {
        sqlStmt("UPDATE " + table + " SET " + columnName + " = " + value + " WHERE " + condition, false);
    }

    /**
     * @param table     Table name
     * @param condition WHERE condition
     */
    private static void delete(String table, String condition) {
        sqlStmt("Delete from " + table + " WHERE " + condition, false);
    }

}
