package EA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tools {
    public static ResultSet query(String statement){

        try {
            Conex connex = new Conex();
            PreparedStatement kontsulta = connex.getConnection().prepareStatement(statement);
            ResultSet res = kontsulta.executeQuery();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
