package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.select;
import static EA.Tools.returnObjectList;

public class Game {
    private int id;
    private String name;
    private String genre;
    private float price;//Renombrar Prize a Price
    private int franchieId;

    //Hay que borrar Stock de la base de datos
    public Game() {

    }

    public Game(int id, String name, String genre, float price, int franchieId) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.franchieId = franchieId;
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

    public int getFranchieId() {
        return franchieId;
    }

    public void setFranchieId(int franchieId) {
        this.franchieId = franchieId;
    }

    public static void printGame(ArrayList<Object> games) {
        for (Object g:games) {
            Game game = (Game) g;
            System.out.println("Name: "+game.getName());
            System.out.println("Genre: "+game.getGenre());
            System.out.println("Price: "+game.getPrice());
            Franchise f = (Franchise) select("Franchises","Id = "+game.getFranchieId()).get(0);
            System.out.println("Franchise: "+f.getName());
            System.out.println("``````````````````````````");

        }
    }

}
