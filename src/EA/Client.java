package EA;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.Tools.*;


public class Client {
    private int id;
    private String idCard;
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

    public static ArrayList<Client> selectClient() {
        ArrayList<Client> custList = new ArrayList();
        ResultSet res = query("Select * From ea.Clients");
        boolean exist = false;
        try {

            while (res.next()) {
                exist = true;
                Client cust = new Client(
                        Integer.parseInt(res.getString(1)),

                        );
                cust.setNan(res.getString(1));
                cust.setName(res.getString(2));
                cust.setSurname1(res.getString(3));
                cust.setSurname2(res.getString(4));
                cust.setPhone(res.getInt(5));
                cust.setEmail(res.getString(6));
                cust.setGender(res.getString(7));
                cust.setPayingMethod(res.getString(8));
                custList.add(cust);

            }
            res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        if (exist) {
            return custList;
        } else {
            return null;
        }
    }
}
