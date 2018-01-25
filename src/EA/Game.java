package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.select;
import static EA.Division.printDivision;
import static EA.Franchise.printFranchise;
import static EA.Tools.returnObjectList;
import static EA.Tools.sqlStmt;

public class Game {
    private int id;
    private String name;
    private String genre;
    private float price;//Renombrar Prize a Price
    private int franchiseId;

    public Game() {

    }

    public Game(int id, String name, String genre, float price, int franchiseId) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.franchiseId = franchiseId;
    }

    public static ArrayList<Object> selectGames(ResultSet res, boolean exist) {
        ArrayList<Object> objectList = new ArrayList();
        try {

            while (res.next()) {
                exist = true;
                Game game = new Game(
                        Integer.parseInt(res.getString(1)),
                        res.getString(2),
                        res.getString(3),
                        Float.parseFloat(res.getString(4)),
                        Integer.parseInt(res.getString(5))
                );
                objectList.add(game);

            }
            res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        return returnObjectList(objectList, exist);
    }

    public static void insertGames(String table) {
        String name = Read.String("Enter the name");
        String genre = Read.String("Enter the genre");
        float price = Read.Float("Enter the price");
        int franchiseId;
        boolean repeat;
        do {
            franchiseId = Read.Int("Type the franchise of the game:");
            ArrayList<Object> franchise = select("Franchises", "Name LIKE '%" + franchiseId + "%'");
            if (franchise.size() > 1) {
                System.out.println(franchise.size() + " franchises found:");
                printFranchise(franchise);
                System.out.println("please specify more");
                repeat=true;
            } else if(franchise.size()<1) {
                System.out.println("No franchises found try again");
                repeat=true;
            }else {
                repeat = false;
                Franchise d = (Franchise) franchise.get(0);
                franchiseId=d.getId();
            }
        }while(repeat);

        sqlStmt("Insert into " + table + " (Name,Genre,Price,FranchiseId) VALUES (" + name + "," + genre + "," + price + "," + franchiseId + ")", false);
    }

    public static void printGame(ArrayList<Object> games) {
        for (Object g : games) {
            Game game = (Game) g;
            System.out.println("Name: " + game.getName());
            System.out.println("Genre: " + game.getGenre());
            System.out.println("Price: " + game.getPrice());
            Franchise f = (Franchise) select("Franchises", "Id = " + game.getFranchiseId()).get(0);
            System.out.println("Franchise: " + f.getName());
            System.out.println("``````````````````````````");

        }
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(int franchiseId) {
        this.franchiseId = franchiseId;
    }
}

