package EA;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.delete;
import static EA.DBtools.select;
import static EA.DBtools.update;
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

    public static void insertGames() {
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
                repeat = true;
            } else if (franchise.size() < 1) {
                System.out.println("No franchises found try again");
                repeat = true;
            } else {
                repeat = false;
                Franchise d = (Franchise) franchise.get(0);
                franchiseId = d.getId();
            }
        } while (repeat);

        sqlStmt("Insert into games (Name,Genre,Price,FranchiseId) VALUES (" + name + "," + genre + "," + price + "," + franchiseId + ")", false);
    }

    public static void deleteGames(){
        boolean repeat;
        int gameId;
        do {
            gameId = Read.Int("Type the name of the game you want to delete:");
            ArrayList<Object> games = select("Games", "Name LIKE '%" + gameId + "%'");
            if (games.size() > 1) {
                System.out.println(games.size() + " games found:");
                printGame(games);
                System.out.println("please specify more");
                repeat=true;
            } else if(games.size()<1) {
                System.out.println("No games found try again");
                repeat=true;
            }else {
                repeat = false;
                Game g = (Game) games.get(0);
                gameId=g.getId();
            }
        }while(repeat);

        sqlStmt("Delete from games where id="+gameId,false);
    }

    public static void updateGame() {
        boolean repeat = false;
        int gameId = 0;
        Game g = null;
        String value = "";
        do {
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
            System.out.println("Enter what field you wish to change");
            System.out.println("+            [1] Name             +");
            System.out.println("+            [2] Genre             +");
            int option = Read.Int("+           [3] Price           +");
            switch (option) {
                case 1:
                    value = Read.String("Enter the new name");
                    update("Studios", "Name", value, "id=" + g.getId());
                    break;
                case 2:
                    value = Read.String("Enter the new genre");
                    update("Studios", "genre", value, "id=" + g.getId());
                    break;
                case 3:
                    value = Read.String("Enter the new price");
                    update("Studios", "price", value, "id=" + g.getId());
                    break;
                default:
                    System.out.println("You have to enter a valid number");
                    repeat = true;
            }
        } while (repeat);

    }

    public static void deleteGame() throws IOException {

        boolean repeat = false;
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
                Game g = (Game) games.get(0);
                gameId = g.getId();
                delete("games", "Id = " + gameId);
                System.out.println(g.getName() + " has been deleted");
                Read.Pause();
            }

        } while (repeat);
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

