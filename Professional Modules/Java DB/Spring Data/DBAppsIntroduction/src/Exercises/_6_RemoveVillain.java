package Exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class _6_RemoveVillain {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final String COUNT_OF_MINIONS = "SELECT COUNT(minion_id) AS count FROM minions_villains AS mv WHERE villain_id=?";
        final String DELETE_MINIONS = "DELETE mv FROM minions_villains AS mv WHERE mv.villain_id=?";
        final String DELETE_VILLAINS = "DELETE FROM villains WHERE id=?";
        final String SELECT_VILLAIN_NAME = "SELECT name FROM villains WHERE id=?";
        final String NO_SUCH_VILLAIN = "No such villain was found";
        final String VILLAIN_DELETED = "%s was deleted%n";
        final String MINIONS_RELEASED = "%d minions released";

        int villainId = Integer.parseInt(scanner.nextLine());

        Connection connection = Utils.getSQLConnection();

        try {
            PreparedStatement villainName = connection.prepareStatement(SELECT_VILLAIN_NAME);
            villainName.setInt(1, villainId);
            ResultSet villainNameSet = villainName.executeQuery();
            villainNameSet.next();
            String villain = villainNameSet.getString(Constants.COLUMN_NAME);

            PreparedStatement queryCountOfMinions = connection.prepareStatement(COUNT_OF_MINIONS);
            queryCountOfMinions.setInt(1, villainId);
            ResultSet minionCountSet = queryCountOfMinions.executeQuery();
            minionCountSet.next();
            int countOfMinions = minionCountSet.getInt(Constants.COLUMN_COUNT);

            PreparedStatement releaseMinions = connection.prepareStatement(DELETE_MINIONS);
            releaseMinions.setInt(1, villainId);
            releaseMinions.executeUpdate();

            PreparedStatement deleteVillain = connection.prepareStatement(DELETE_VILLAINS);
            deleteVillain.setInt(1, villainId);
            deleteVillain.executeUpdate();

            System.out.printf(VILLAIN_DELETED, villain);
            System.out.printf(MINIONS_RELEASED, countOfMinions);
        } catch (SQLException e) {
            System.out.println(NO_SUCH_VILLAIN);
        }

    }
}
