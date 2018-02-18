package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.*;
import static EA.Division.printDivision;
import static EA.Game.printGame;
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

    public static void insertStudios() {
        String name = Read.String("Enter the name");
        String country = Read.String("Enter the country");
        int divisionId;
        boolean repeat;
        do {
            String n = Read.String("Type the divison name  of the studio: ");
            ArrayList<Object> division = select("Divisions", "Name LIKE '%" + n + "%'");
            if (division != null) {
                if (division.size() > 1) {
                    System.out.println(division.size() + " divisions found:");
                    System.out.println("please specify more");
                    repeat = true;
                } else {
                    repeat = false;
                    Division d = (Division) division.get(0);
                    divisionId = d.getId();
                    sqlStmt("Insert into Studios (Name,Country,DivisionId) VALUES ('" + name + "','" + country + "'," + divisionId + ")", false);

                }

            } else {
                System.out.println("No divisions found");
                repeat = false;
            }
        } while (repeat);

    }

    public static void deleteStudio() {
        boolean repeat;
        int studioId;
        ArrayList<Object> studio = null;
        do {
            String n = Read.String("Type the studio to delete:");
            studio = select("Studios", "Name LIKE '%" + n + "%'");
            if (studio != null) {
                if (studio.size() > 1) {
                    System.out.println(studio.size() + " studios found:");
                    System.out.println("please specify more");
                    repeat = true;
                } else {
                    repeat = false;
                    Studio s = (Studio) studio.get(0);
                    studioId = s.getId();
                    sqlStmt("delete from studios where id=" + studioId, false);

                }

            } else {
                System.out.println("No Studios found, try again");
                repeat = false;
            }
        } while (repeat);
    }

    public static void printStudio(ArrayList<Object> studios) {
        for (Object s : studios) {
            Studio studio = (Studio) s;
            System.out.println("Name: " + studio.getName());
            System.out.println("Country: " + studio.getCountry());
            Division d = (Division) select("Divisions", "Id = " + studio.getDivisionId()).get(0);
            System.out.println("Division: " + d.getName());
            System.out.println("``````````````````````````");

        }

    }

    public static void updateStudios() {
        boolean repeat = false;
        int studioId = 0;
        ArrayList<Object> studios = null;
        String value = "";
        do {
            do {
                String name = Read.String("Type the name of the studio:");
                studios = select("studios", "Name LIKE '%" + name + "%'");
                if (studios!=null) {
                    if (studios.size() > 1){
                        System.out.println(studios.size() + " studios found:");
                        System.out.println("please specify more");
                        repeat = true;
                    }else{
                        repeat = false;
                        Studio c = (Studio) studios.get(0);
                        studioId = c.getId();
                    }

                }else {
                    System.out.println("No studios found try again");
                    repeat = true;

                }
            } while (repeat);
            System.out.println("Enter what field you wish to change");
            System.out.println("+            [1] name             +");
            int option = Read.Int("+           [2] Country           +");
            switch (option) {
                case 1:
                    value = Read.String("Enter the new name");
                    update("Studios", "Name", value, "id=" + studioId);
                    break;
                case 2:
                    value = Read.String("Enter the new country");
                    update("Studios", "Country", value, "id=" + studioId);
                    break;
                default:
                    System.out.println("You have to enter a valid number");
                    repeat = true;
            }
        } while (repeat);

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
