package EA;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tools {
    /**
     * @param statement The SQL statement to be executed.
     * @param query     False: It's a Delete/Insert/Update statement
     *                  True: It's a Query
     * @return
     */
    public static ResultSet sqlStmt(String statement, boolean query) {
        //Set up the conexion
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDatabaseName("ea");
        dataSource.setServerName("127.0.0.1");
        Connection conn;
        Statement stmt;
        if (query) {

            ResultSet rs;
            try {
                //Try to connect
                conn = (Connection) dataSource.getConnection();
                stmt = (Statement) conn.createStatement();
                rs = stmt.executeQuery(statement);
                //Return the result of the sqlStmt
                return rs;
            } catch (SQLException ex) {
                System.out.println("Error with the DB");
            }
        } else {
            try {
                //Try to connect
                conn = (Connection) dataSource.getConnection();
                stmt = (Statement) conn.createStatement();
                stmt.execute(statement);

                return null;
            } catch (SQLException ex) {
                System.out.println("Error with the DB");
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
    public static void cls() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}
