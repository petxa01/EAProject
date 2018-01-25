package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.Tools.returnObjectList;
import static EA.Tools.sqlStmt;


public class Client {
    private int id;
    private String idCard; //Añadir en la datubase
    private String name;
    private String category;

    public Client() {

    }

    public Client(int id, String idCard, String name, String category) {
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
    public static void insertClients(String table){
        String idCard=Read.String("Enter the id card");
        String name=Read.String("Enter the Client name");
        String category=Read.String("Enter the client category");

        sqlStmt("Insert into "+ table +" (Name, Category,IdCard) VALUES ("+name+","+category+","+idCard+")", false);
    }

    public static void deleteClients(){

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
