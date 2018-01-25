package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.select;
import static EA.Game.printGame;
import static EA.Tools.returnObjectList;
import static EA.Tools.sqlStmt;

public class Develop {

    int developerId;
    int gameId;
    boolean finished;

    public Develop() {
    }

    public Develop(int developerId, int gameId, boolean finished) {
        this.developerId = developerId;
        this.gameId = gameId;
        this.finished = finished;
    }

    /**
     * @param res   resultado del sqlStmt
     * @param exist comprobacion de si el result no esta vacio
     * @return devuelve los resultados en un arrayList de objetos es null si el result esta vacio
     */
    public static ArrayList<Object> selectDevelop(ResultSet res, boolean exist) {
        ArrayList<Object> objectList = new ArrayList();
        try {

            while (res.next()) {
                exist = true;
                Develop develop = new Develop(
                        Integer.parseInt(res.getString(1)),
                        Integer.parseInt(res.getString(2)),
                        Boolean.parseBoolean(res.getString(3))
                );

                objectList.add(develop);

            }
            res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        return returnObjectList(objectList, exist);
    }
    public static void insertDevelops(String table){
        boolean repeat;
        int gameId;
        int devId;
        do {
            gameId = Read.Int("Type the name of the game:");
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
        do {
            devId = Read.Int("Type the id card of the developer:");
            ArrayList<Object> developers = select("Developers", "IdCard LIKE '%" + devId + "%'");
            if (developers.size() > 1) {
                System.out.println(developers.size() + " developers found:");
                printGame(developers);
                System.out.println("please specify more");
                repeat=true;
            } else if(developers.size()<1) {
                System.out.println("No developers found try again");
                repeat=true;
            }else {
                repeat = false;
                Developer d = (Developer) developers.get(0);
                devId=d.getId();
            }
        }while(repeat);
        boolean finished=Read.Boolean("Enter the game status(true if finished)");

        sqlStmt("Insert into "+ table +" (DeveloperID, GameID,Finished) VALUES ("+devId+","+gameId+","+finished+")", false);
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
