package EA;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.delete;
import static EA.DBtools.select;
import static EA.DBtools.update;
import static EA.Game.printGame;
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

    public static void deleteGameF() throws IOException {
        boolean repeat = false;
        Game g = null;
        int gameId = 0;
        do {
            String name = Read.String("Type the name of the game:");
            ArrayList<Object> games = select("games", "Name LIKE '%" + name + "%'");
            if (games.size() > 1) {
                System.out.println(games.size() + " games found:");
                printGame(games);
                System.out.println("please specify more");
                repeat = true;
            } else if (games.size() < 1) {
                System.out.println("No games found try again");
                repeat = true;
            } else {
                repeat = false;
                g = (Game) games.get(0);
                gameId = g.getId();
                update("Games", "FranchiseId", "null", "Id = " + gameId);
                System.out.println(g.getName() + " is not in a franchise anymore");
                Read.Pause();
            }

        } while (repeat);
    }

    public static void updateFranchise() throws IOException {
        boolean repeat = false;
        int franId = 0;
        String value = "";

        do {
            String name = Read.String("Type the name of the franchise:");
            ArrayList<Object> franchises = select("franchises", "Name LIKE '%" + name + "%'");
            if (franchises.size() > 1) {
                System.out.println(franchises.size() + " franchises found:");
                printFranchise(franchises);
                System.out.println("please specify more");
                repeat = true;
            } else if (franchises.size() < 1) {
                System.out.println("No franchises found try again");
                repeat = true;
            } else {
                repeat = false;
                Franchise f = (Franchise) franchises.get(0);
                franId = f.getId();
                value = Read.String("Enter the new name for \"" + f.getName() + "\": ");
                update("franchises", "name", value, "Id = " + f.getId());
                System.out.println("Done");
                Read.Pause();

            }
        } while (repeat);


    }

    public static void addGame() throws IOException {
        boolean repeat = false;
        Game g = null;
        Franchise f;
        int gameId = 0;
        int franId = 0;
        do {
            String name = Read.String("Type the name of the game:");
            ArrayList<Object> games = select("games", "Name LIKE '%" + name + "%'");
            if (games.size() > 1) {
                System.out.println(games.size() + " games found:");
                printGame(games);
                System.out.println("please specify more");
                repeat = true;
            } else if (games.size() < 1) {
                System.out.println("No games found try again");
                repeat = true;
            } else {
                repeat = false;
                g = (Game) games.get(0);
                gameId = g.getId();
            }

        } while (repeat);
        repeat = true;
        do {
            String name = Read.String("Now type the name of the franchise:");
            ArrayList<Object> franchises = select("franchises", "Name LIKE '%" + name + "%'");
            if (franchises.size() > 1) {
                System.out.println(franchises.size() + " franchises found:");
                printFranchise(franchises);
                System.out.println("please specify more");
                repeat = true;
            } else if (franchises.size() < 1) {
                System.out.println("No franchises found try again");
                repeat = true;
            } else {
                repeat = false;
                f = (Franchise) franchises.get(0);
                franId = f.getId();
                update("Games", "FranchiseId", Integer.toString(franId), "Id = " + gameId);
                System.out.println(g.getName() + " has been added to " + f.getName() + " franchise");
                Read.Pause();
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

    public static void insertFranchise() {
        boolean repeat = true;
        int studioId;
        String name = Read.String("Enter the name");
        do {
            studioId = Read.Int("Type the studio of the franchise:");
            ArrayList<Object> studio = select("Studios", "Name LIKE '%" + studioId + "%'");
            if (studio.size() > 1) {
                System.out.println(studio.size() + " studios found:");
                printStudio(studio);
                System.out.println("please specify more");
                repeat = true;
            } else if (studio.size() < 1) {
                System.out.println("No studios found try again");
                repeat = true;
            } else {
                repeat = false;
                Studio s = (Studio) studio.get(0);
                studioId = s.getId();
            }
        } while (repeat);
        sqlStmt("Insert into franchises (Name,StudioId) VALUES (" + name + "," + studioId + ")", false);
    }

    public static void deleteFranchise() throws IOException {


        boolean repeat = false;
        int franid = 0;

        do {
            String name = Read.String("Type the name of the franchise:");
            ArrayList<Object> franchises = select("franchises", "Name LIKE '%" + name + "%'");
            if (franchises.size() > 1) {
                System.out.println(franchises.size() + " franchises found:");
                printFranchise(franchises);
                System.out.println("please specify more");
                repeat = true;
            } else if (franchises.size() < 1) {
                System.out.println("No franchises found try again");
                repeat = true;
            } else {
                repeat = false;
                Franchise f = (Franchise) franchises.get(0);
                franid = f.getId();
                update("Games", "FranchiseId", "null", "FranchiseId = " + franid);
                delete("franchises", "Id = " + franid);
                System.out.println(f.getName() + " has been deleted");
                Read.Pause();
            }

        } while (repeat);
    }

    public static void printFranchise(ArrayList<Object> franchises) {
        for (Object f : franchises) {
            Franchise franchise = (Franchise) f;
            System.out.println("Name: " + franchise.getName());
            Studio s = (Studio) select("Studios", "Id = " + franchise.getStudioId()).get(0);
            System.out.println("\tStudio: " + s.getName());
            System.out.println("``````````````````````````");
        }
    }


}
