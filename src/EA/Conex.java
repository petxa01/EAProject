package EA;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Conex {
    static String bd ="ea";
    String login= "root";
    static String password = "root";
    static String url = "jdbc:mysql://localhost:3306/"+bd;

    Connection connex=null;

    public Conex() {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connex = DriverManager.getConnection(url,login,password);
            if(connex!=null){
                //System.out.println("Conectatuta!!!");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound");
        } catch (SQLException ex) {
            System.out.println("SQLException");
        }
    }


    public Connection getConnection(){
        return connex;
    }
    public void disconect(){
        connex=null;
    }


}
