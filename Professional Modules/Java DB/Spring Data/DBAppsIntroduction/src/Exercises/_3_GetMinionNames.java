package DBAppsIntroduction.Exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class _3_GetMinionNames {
    public static void main(String[] args) throws SQLException {

        final String NO_VILLAIN_WITH_ID="No villain with ID %d exists in the database.";
        final String VILLAIN_NAME="Villain: %s%n";
        final String MINION_NAME_AGE="%d. %s %d%n";
        final String SELECT_VILLAIN_NAME="SELECT name FROM villains WHERE id=?";
        final String SELECT_VILLAIN_MINIONS="SELECT name, age FROM minions AS m JOIN minions_villains mv on m.id = mv.minion_id WHERE villain_id=?";

        Scanner scanner = new Scanner(System.in);

        Connection connection = Utils.getSQLConnection();

        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement queryVillainName = connection.prepareStatement(SELECT_VILLAIN_NAME);

        queryVillainName.setInt(1, villainId);
        ResultSet villainNameSet = queryVillainName.executeQuery();

        PreparedStatement queryMinionsForVillain = connection.prepareStatement(SELECT_VILLAIN_MINIONS);

        queryMinionsForVillain.setInt(1, villainId);
        ResultSet minionsNameAgeSet=queryMinionsForVillain.executeQuery();

        if (villainNameSet.next()) {
            String villainName=villainNameSet.getString(Constants.COLUMN_NAME);
            System.out.printf(VILLAIN_NAME,villainName);

            int index=1;

            while (minionsNameAgeSet.next()){
                String minionName=minionsNameAgeSet.getString(Constants.COLUMN_NAME);
                int minionAge=minionsNameAgeSet.getInt(Constants.COLUMN_AGE);

                System.out.printf(MINION_NAME_AGE,index,minionName,minionAge);
                index++;
            }

        }else {
            System.out.printf(NO_VILLAIN_WITH_ID,villainId);
        }

        connection.close();
    }
}
