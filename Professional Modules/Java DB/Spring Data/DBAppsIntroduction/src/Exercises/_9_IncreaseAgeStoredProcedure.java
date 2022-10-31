package DBAppsIntroduction.Exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class _9_IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final String INVOKE_PROCEDURE="CALL usp_get_older(?)";
        final String GET_MINION_NAME_AND_AGE="SELECT name,age FROM minions WHERE id=?";
        final String NO_SUCH_MINION="No such minion";
        final String PRINT_MINION_NAME_AND_AGE="%s %d";
        int minionId=Integer.parseInt(scanner.nextLine());

        Connection connection = Utils.getSQLConnection();

        PreparedStatement invokeProcedure=connection.prepareStatement(INVOKE_PROCEDURE);
        invokeProcedure.setInt(1,minionId);
        invokeProcedure.executeUpdate();

        PreparedStatement getMinionNameAndAge=connection.prepareStatement(GET_MINION_NAME_AND_AGE);
        getMinionNameAndAge.setInt(1,minionId);
        ResultSet minionNameAndAngeSet=getMinionNameAndAge.executeQuery();

        if (!minionNameAndAngeSet.next()){
            System.out.println(NO_SUCH_MINION);
            return;
        }

        String minionName=minionNameAndAngeSet.getString(Constants.COLUMN_NAME);
        int minionAge=minionNameAndAngeSet.getInt(Constants.COLUMN_AGE);

        System.out.printf(PRINT_MINION_NAME_AND_AGE,minionName,minionAge);

    }
}
