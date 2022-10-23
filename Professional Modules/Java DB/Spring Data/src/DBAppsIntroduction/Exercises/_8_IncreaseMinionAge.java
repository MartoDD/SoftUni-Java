package DBAppsIntroduction.Exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _8_IncreaseMinionAge {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final String INCREASE_MINION_AGE = "UPDATE minions SET age=age+1 WHERE id=?";
        final String GET_ALL_MINIONS = "SELECT name, age FROM minions";
        final String PRINT_MINION_INFORMATION = "%s %d%n";

        Connection connection = Utils.getSQLConnection();

        List<Integer> minionIds = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        PreparedStatement increaseMinionAge = connection.prepareStatement(INCREASE_MINION_AGE);

        for (Integer minionId : minionIds) {
            increaseMinionAge.setInt(1, minionId);
            increaseMinionAge.executeUpdate();
        }

        PreparedStatement getAllMinions = connection.prepareStatement(GET_ALL_MINIONS);
        ResultSet allMinions = getAllMinions.executeQuery();

        while (allMinions.next()) {

            String minionName = allMinions.getString(Constants.COLUMN_NAME);
            int minionAge = allMinions.getInt(Constants.COLUMN_AGE);

            System.out.printf(PRINT_MINION_INFORMATION, minionName, minionAge);

        }

    }
}
