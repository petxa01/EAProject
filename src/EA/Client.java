package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.DBtools.select;
import static EA.DBtools.update;
import static EA.Game.printGame;
import static EA.Tools.returnObjectList;
import static EA.Tools.sqlStmt;


public class Client {
    private int id;
    private String idCard; //Añadir en la datubase
    private String name;
    private String category;

    public Client() {

    }

    public Client(int id, String name,String category, String idCard) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.category = category;
    }

    /**
     * @param res   resultado del sqlStmt
     * @param exist comprobacion de si el result no esta vacio
     * @return devuelve los resultados en un arrayList de objetos es null si el result esta vacio
     */
    public static ArrayList<Object> selectClients(ResultSet res, boolean exist) {
        ArrayList<Object> objectList = new ArrayList();
        try {


            while (res.next()) {
                exist = true;
                Client client = new Client(
                        Integer.parseInt(res.getString(1)),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4)
                );

                objectList.add(client);

            }
            res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        return returnObjectList(objectList, exist);
    }
    public static void insertClients(){
        String idCard=Read.String("Enter the id card: ");
        String name=Read.String("Enter the Client name: ");
        String category=Read.String("Enter the client category: ");

        sqlStmt("Insert into clients (Name, Category,IdCard) VALUES ("+name+","+category+","+idCard+")", false);
    }

    public static void deleteClients(){
        int clientId;
        boolean repeat;
        do {
            clientId = Read.Int("Type the id card of the client you want to delete:");
            ArrayList<Object> client = select("Clients", "IdCard LIKE '%" + clientId + "%'");
            if (client.size() > 1) {
                System.out.println(client.size() + " clients found:");
                printClient(client);
                System.out.println("please specify more");
                repeat = true;
            } else if (client.size() < 1) {
                System.out.println("No Clients found try again");
                repeat = true;
            } else {
                repeat = false;
                Client c = (Client) client.get(0);
                clientId = c.getId();
            }
        } while (repeat);
        sqlStmt("delete from clients where id= "+ clientId,false);

    }

    public static void updateClient(){
        boolean repeat;
        int clientId, menu;
        String column, value;
        do {
            clientId = Read.Int("Type the id card of the client you want to update:");
            ArrayList<Object> developers = select("Clients", "IdCard LIKE '%" + clientId + "%'");
            if (developers.size() > 1) {
                System.out.println(developers.size() + " clients found:");
                printGame(developers);
                System.out.println("please specify more");
                repeat = true;
            } else if (developers.size() < 1) {
                System.out.println("No clients found try again");
                repeat = true;
            } else {
                repeat = false;
                Developer d = (Developer) developers.get(0);
                clientId = d.getId();
            }
        } while (repeat);
        do {
            System.out.println("Choose what do you want to change");
            System.out.println("1- Name");
            menu = Read.Int("2- Category");
        }while(menu<1 || menu>2);
        switch (menu){
            case 1:
                column="Name";
                break;
            case 2:
                column="Category";
                break;
            default:
                column="";
        }
        value=Read.String("Enter the new value");
        update("Clients",column,value,"id="+clientId);


    }
    public static void printClient(ArrayList<Object> clients){
        for (Object f : clients) {
            Client client = (Client) f;
            System.out.println("Name: " + client.getName());
            System.out.printf("Id Card: " + client.getIdCard());
            System.out.println("Category: " + client.getCategory());

            System.out.println("``````````````````````````");
        }
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
