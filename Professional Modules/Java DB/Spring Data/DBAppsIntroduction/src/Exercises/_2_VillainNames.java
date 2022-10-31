package DBAppsIntroduction.Exercises;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class _2_VillainNames {
    public static void main(String[] args) throws SQLException {

        final String SELECT_VILLAIN_AND_MINION_COUNT = "SELECT v.name, COUNT(DISTINCT (mv.minion_id)) AS count FROM villains as v JOIN minions_villains mv on v.id = mv.villain_id GROUP BY v.name HAVING count>15 ORDER BY count DESC;";
        final String PRINT_VILLAIN_MINION_COUNT="%s %s";

        Connection connection = Utils.getSQLConnection();

        PreparedStatement query = connection.prepareStatement(SELECT_VILLAIN_AND_MINION_COUNT);

        ResultSet resultSet = query.executeQuery();

        while (resultSet.next()) {
            String villainName=resultSet.getString(Constants.COLUMN_NAME);
            String minionsCount = resultSet.getString(Constants.COLUMN_COUNT);
            System.out.printf(PRINT_VILLAIN_MINION_COUNT,villainName,minionsCount);
        }

        connection.close();
    }
}
