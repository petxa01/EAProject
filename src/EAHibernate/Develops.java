package EAHibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(DevelopsPK.class)
public class Develops {
    private int developerId;
    private int gameId;
    private byte finished;
    private Developers developersByDeveloperId;
    private Games gamesByGameId;

    @Id
    @Column(name = "DeveloperId", nullable = false)
    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    @Id
    @Column(name = "GameId", nullable = false)
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "Finished", nullable = false)
    public byte getFinished() {
        return finished;
    }

    public void setFinished(byte finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Develops develops = (Develops) o;
        return developerId == develops.developerId &&
                gameId == develops.gameId &&
                finished == develops.finished;
    }

    @Override
    public int hashCode() {

        return Objects.hash(developerId, gameId, finished);
    }

    @ManyToOne
    @JoinColumn(name = "DeveloperId", referencedColumnName = "Id", nullable = false)
    public Developers getDevelopersByDeveloperId() {
        return developersByDeveloperId;
    }

    public void setDevelopersByDeveloperId(Developers developersByDeveloperId) {
        this.developersByDeveloperId = developersByDeveloperId;
    }

    @ManyToOne
    @JoinColumn(name = "GameId", referencedColumnName = "Id", nullable = false)
    public Games getGamesByGameId() {
        return gamesByGameId;
    }

    public void setGamesByGameId(Games gamesByGameId) {
        this.gamesByGameId = gamesByGameId;
    }
}
