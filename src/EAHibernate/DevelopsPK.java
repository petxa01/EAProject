package EAHibernate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DevelopsPK implements Serializable {
    private int developerId;
    private int gameId;

    @Column(name = "DeveloperId", nullable = false)
    @Id
    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    @Column(name = "GameId", nullable = false)
    @Id
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevelopsPK that = (DevelopsPK) o;
        return developerId == that.developerId &&
                gameId == that.gameId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(developerId, gameId);
    }
}
