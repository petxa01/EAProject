package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.select;
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
    public static void insertDivisions(){
        String name=Read.String("Enter the name");

        sqlStmt("Insert into divisions (Name) VALUES ("+name+")", false);
    }
    public static void printDivision(ArrayList<Object> divisions) {
        for (Object g : divisions) {
            Division division = (Division) g;
            System.out.println("Name: " + division.getName());

        }
    }
    public static void deleteDivision(){
        int divisionId;
        boolean repeat;
        do {
            divisionId = Read.Int("Type the divison you want to delete:");
            ArrayList<Object> division = select("Divisions", "Name LIKE '%" + divisionId + "%'");
            if (division.size() > 1) {
                System.out.println(division.size() + " divisions found:");
                printDivision(division);
                System.out.println("please specify more");
                repeat=true;
            } else if(division.size()<1) {
                System.out.println("No divisons found try again");
                repeat=true;
            }else {
                repeat = false;
                Division d = (Division) division.get(0);
                divisionId=d.getId();
            }
        }while(repeat);
        sqlStmt("delkete from divisions where id = "+divisionId,false);
    }


}
