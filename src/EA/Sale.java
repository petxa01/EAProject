package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static EA.DBtools.select;
import static EA.Game.printGame;
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
        boolean repeat=false;
        int gameId=0, clientId=0;
        System.out.println("Enter the quantity");
        int quantity=Read.Int();
        System.out.println("Enter the Date");
        LocalDate date = LocalDate.now();
        do {
            System.out.println("Type the name of the game:");
            String gameName = Read.String();
            ArrayList<Object> games = select("Games", "Name LIKE '%" + gameName + "%'");
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
            System.out.println("Type the id card of the client:");
            int cardId = Read.Int();
            ArrayList<Object> clients = select("Clients", "IdCard LIKE '%" + cardId + "%'");
            if (clients.size() > 1) {
                System.out.println(clients.size() + " clients found:");
                printGame(clients);
                System.out.println("please specify more");
                repeat=true;
            } else if(clients.size()<1) {
                System.out.println("No clients found try again");
                repeat=true;
            }else {
                repeat = false;
                Client c = (Client) clients.get(0);
                clientId=c.getId();
            }
        }while(repeat);




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
