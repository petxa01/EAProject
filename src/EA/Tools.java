package EA;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tools {
    /**
     *
     * @param statement The SQL statement to be executed.
     * @param returns False: It's a Delete/Insert/Update
     *                True: It's a Query
     * @return
     */
    public static ResultSet query(String statement, boolean returns) {
        //Set up the conexion
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setDatabaseName("Ea");
        dataSource.setServerName("127.0.0.1");
        Connection conn;
        Statement stmt;
        if (returns) {

            ResultSet rs;
            try {
                //Try to connect
                conn = (Connection) dataSource.getConnection();
                stmt = (Statement) conn.createStatement();
                rs = stmt.executeQuery(statement);
                //Return the result of the query
                return rs;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "There has been an error with the DB.",
                        "Oh oh",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                //Try to connect
                conn = (Connection) dataSource.getConnection();
                stmt = (Statement) conn.createStatement();
                stmt.execute(statement);

                return null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "There has been an error with the DB.",
                        "Oh oh",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
    public static ArrayList<Object> returnObjectList(ArrayList<Object> objectList, boolean exist) {
        if (exist)
            return objectList;
        else
            return null;
    }
}
