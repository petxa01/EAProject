package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.Tools.returnObjectList;
import static EA.Tools.sqlStmt;

public class Studio {
    private int id;
    private String name;
    private String country;
    private int divisionId;

    public Studio() {
    }

    public Studio(int id, String name, String country, int divisionId) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.divisionId = divisionId;
    }

    public static ArrayList<Object> selectStudios(ResultSet res, boolean exist) {
        ArrayList<Object> objectList = new ArrayList();
        try {

            while (res.next()) {
                exist = true;
                Studio studio = new Studio(
                        Integer.parseInt(res.getString(1)),
                        res.getString(2),
                        res.getString(3),
                        Integer.parseInt(res.getString(4))
                );

                objectList.add(studio);

            }
            res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        return returnObjectList(objectList, exist);
    }

    public static void insertStudios(String table, int divisionId) {

        String name = Read.String("Enter the name");
        String country = Read.String("Enter the country");

        sqlStmt("Insert into " + table + " (Name,Country,DivisionId) VALUES (" + name + "," + country + "," + divisionId + ")", false);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }
}
