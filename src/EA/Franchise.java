package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.select;
import static EA.Studio.printStudio;
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

    public static void insertFranchise(){
        boolean repeat=true;
        int studioId;
        String name=Read.String("Enter the name");
        do {
            studioId = Read.Int("Type the studio of the franchise:");
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
