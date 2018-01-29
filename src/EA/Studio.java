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

    public static void insertStudios(String table) {
        String name = Read.String("Enter the name");
        String country = Read.String("Enter the country");
        int divisionId;
        boolean repeat;
        do {
            divisionId = Read.Int("Type the divison of the studio:");
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

        sqlStmt("Insert into " + table + " (Name,Country,DivisionId) VALUES (" + name + "," + country + "," + divisionId + ")", false);
    }

    public static void deleteStudio(){
        boolean repeat;
        int studioId;
        do {
            studioId = Read.Int("Type the studio to delete:");
            ArrayList<Object> studio = select("Studios", "Name LIKE '%" + studioId + "%'");
            if (studio.size() > 1) {
                System.out.println(studio.size() + " studios found:");
                printStudio(studio);
                System.out.println("please specify more");
                repeat=true;
            } else if(studio.size()<1) {
                System.out.println("No studios found try again");
                repeat=true;
            }else {
                repeat = false;
                Studio s = (Studio) studio.get(0);
                studioId=s.getId();
            }
        }while(repeat);
        sqlStmt("delete from studios where id="+studioId,false);
    }

    public static void printStudio(ArrayList<Object> studios) {
        for (Object g : studios) {
            Studio studio = (Studio) g;
            System.out.println("Name: " + studio.getName());
            System.out.println("Country: " + studio.getCountry());
            Division d = (Division) select("Division", "Id = " + studio.getDivisionId()).get(0);
            System.out.println("Division: " + d.getName());
            System.out.println("``````````````````````````");

        }
    }

    public static void updateStudios() {
        boolean repeat = false;
        int studioId = 0;
        String value = "";
        do {
            do {
                String name = Read.String("Type the name of the studio:");
                ArrayList<Object> studios = select("studios", "IdCard LIKE '%" + name + "%'");
                if (studios.size() > 1) {
                    System.out.println(studios.size() + " clients found:");
                    printGame(studios);
                    System.out.println("please specify more");
                    repeat = true;
                } else if (studios.size() < 1) {
                    System.out.println("No clients found try again");
                    repeat = true;
                } else {
                    repeat = false;
                    Studio c = (Studio) studios.get(0);
                    studioId = c.getId();

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
