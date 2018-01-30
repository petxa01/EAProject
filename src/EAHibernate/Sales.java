package EAHibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Sales {
    private int id;
    private int quantity;
    private Date date;
    private Integer gameId;
    private Integer clientId;
    private Games gamesByGameId;
    private Clients clientsByClientId;

    public Sales(){

    }

    public Sales(int id){
        this.id=id;
    }

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "GameId", nullable = true)
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "ClientId", nullable = true)
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return id == sales.id &&
                quantity == sales.quantity &&
                Objects.equals(date, sales.date) &&
                Objects.equals(gameId, sales.gameId) &&
                Objects.equals(clientId, sales.clientId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, quantity, date, gameId, clientId);
    }

    @ManyToOne
    @JoinColumn(name = "GameId", referencedColumnName = "Id")
    public Games getGamesByGameId() {
        return gamesByGameId;
    }

    public void setGamesByGameId(Games gamesByGameId) {
        this.gamesByGameId = gamesByGameId;
    }

    @ManyToOne
    @JoinColumn(name = "ClientId", referencedColumnName = "Id")
    public Clients getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(Clients clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }
}
