package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.Tools.returnObjectList;
import static EA.Tools.sqlStmt;

public class Division {
    private int id;
    private String Name;

    public Division() {

    }

    public Division(int id, String name) {
        this.id = id;
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static ArrayList<Object> selectDivisions(ResultSet res, boolean exist) {
        ArrayList<Object> objectList = new ArrayList();
        try {

            while (res.next()) {
                exist = true;
                Division division = new Division(
                        Integer.parseInt(res.getString(1)),
                        res.getString(2)
                );
                objectList.add(division);

            }
            res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        return returnObjectList(objectList, exist);
    }
    public static void insertDivisions(String table){
        System.out.println("Enter the name");
        String name=Read.String();

        sqlStmt("Insert into "+ table +" (Name) VALUES ("+name+")", false);
    }


}
