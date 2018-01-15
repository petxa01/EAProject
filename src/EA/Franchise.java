package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.select;
import static EA.Tools.returnObjectList;
import static EA.Tools.sqlStmt;

public class Franchise {
    int id;
    String name;
    int studioId;

    public Franchise() {
    }

    public Franchise(int id, String name, int studioId) {
        this.id = id;
        this.name = name;
        this.studioId = studioId;
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

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }
    public static ArrayList<Object> selectFranchises(ResultSet res, boolean exist) {
        ArrayList<Object> objectList = new ArrayList();
        try {

            while (res.next()) {
                exist = true;
                Franchise franchise = new Franchise(
                        Integer.parseInt(res.getString(1)),
                        res.getString(2),
                        Integer.parseInt(res.getString(3))
                );

                objectList.add(franchise);

            }
            res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        return returnObjectList(objectList, exist);
    }
    //TODO: Completar método con LIKE
    public static void insertFranchise(){
        String name=Read.String("Enter the name");

        sqlStmt("Insert into franchises (Name,StudioId) VALUES ("+name+","+studioId+")", false);
    }

    public static void printFranchise(ArrayList<Object> franchises) {
        for (Object f:franchises) {
            Franchise franchise = (Franchise) f;
            System.out.println("Name: "+franchise.getName());
            Studio s = (Studio) select("Studios","Id = "+franchise.getStudioId()).get(0);
            System.out.println("\tStudio: "+s.getName());
            System.out.println("``````````````````````````");

        }
    }

}
