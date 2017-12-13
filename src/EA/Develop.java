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

    public static ArrayList<Develop> select() {
        ArrayList<Develop> develops = new ArrayList<>();
        ResultSet rs;
        try {
            rs = query("SELECT * FROM DEVELOPS");

            while (rs.next()) {
                Develop dev = new Develop(
                        Integer.parseInt(rs.getString(1)),
                        Integer.parseInt(rs.getString(2)),
                        Boolean.parseBoolean(rs.getString(3))
                ) {
                };
                develops.add(dev);

            }
            return develops;
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
