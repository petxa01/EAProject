package EA;

import java.sql.ResultSet;
import java.util.ArrayList;

import static EA.Client.*;
import static EA.Develop.*;
import static EA.Tools.*;
import static EA.Developer.*;

public class Management {
    /**
     * @param table nombre de las tablas
     * @param field campo para comparar
     * @param value valor para comparar
     * @return devuelve los resultados en un arrayList de objetos es null si el result esta vacio
     */
    public static ArrayList<Object> Show(String table, String field, String value) {
        ArrayList<Object> ObjectList = new ArrayList();
        ResultSet res = query("Select * From ea." + table + " where " + field + "=" + value);
        boolean exist = false;
        table = table.toLowerCase();
        switch (table) { //tabla es siempre en minusculas
            case "clients":
                return clientsSelect(ObjectList, res, exist);

            case "develops":
                return selectDevelop(ObjectList, res, exist);

            case "developers":
                return selectDevelopers(ObjectList,res,exist);


        }
        return null;
    }




}
