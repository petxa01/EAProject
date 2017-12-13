package EA;

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

}
