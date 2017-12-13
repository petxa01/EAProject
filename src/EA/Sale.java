package EA;

import java.time.LocalDate;

public class Sale {
    int id;
    int quantity;
    LocalDate date;
    int gameId;
    int clientId;

    public Sale() {
    }

    public Sale(int id, int quantity, LocalDate date, int gameId, int clientId) {
        this.id = id;
        this.quantity = quantity;
        this.date = date;
        this.gameId = gameId;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
