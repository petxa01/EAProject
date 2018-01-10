package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static EA.Tools.returnObjectList;
import static EA.Tools.sqlStmt;

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

    public static ArrayList<Object> selectSales(ResultSet res, boolean exist) {
        ArrayList<Object> objectList = new ArrayList();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y M d", Locale.ENGLISH);
            while (res.next()) {
                exist = true;
                Sale sale = new Sale(
                        Integer.parseInt(res.getString(1)),
                        Integer.parseInt(res.getString(2)),
                        LocalDate.parse(res.getString(3), formatter),
                        Integer.parseInt(res.getString(4)),
                        Integer.parseInt(res.getString(5))
                );

                objectList.add(sale);

            }
            res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        return returnObjectList(objectList, exist);
    }

    public static void insertSales(String table){
        System.out.println("Enter the quantity");
        int quantity=Read.Int();
        System.out.println("Enter the Date");
        //TODO insert sale es que acaban de comprar? o metemos fecha random de venta
        LocalDate date;
        System.out.println("Enter the game id");
        int gameId=Read.Int();
        System.out.println("Enter the client ID");
        int clientId = Read.Int();



        sqlStmt("Insert into "+ table +" (Quantity,Date,GameId,ClientId) VALUES ("+quantity+","+date+","+gameId+","+clientId+")", false);
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
