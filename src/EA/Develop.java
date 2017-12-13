package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static EA.Tools.*;

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
    /**
     *
     * @param objectList ArrayList para devolver el valor
     * @param res resultado del query
     * @param exist comprobacion de si el result no esta vacio
     * @return devuelve los resultados en un arrayList de objetos es null si el result esta vacio
     */
    public static ArrayList<Object> selectDevelop(ArrayList<Object> objectList, ResultSet res, boolean exist) {
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
}
