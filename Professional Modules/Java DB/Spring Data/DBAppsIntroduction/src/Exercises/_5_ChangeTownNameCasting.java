package Exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _5_ChangeTownNameCasting {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final String SET_TOWNS_TO_UPPER_CASE = "UPDATE towns SET name=UPPER(name) WHERE country=?";
        final String GET_TOWN_NAMES = "SELECT name FROM towns WHERE country=?";
        final String NO_TOWNS_AFFECTED = "No town names were affected.";
        final String COUNT_OF_AFFECTED_TOWNS="%d town names were affected%n";
        final String countryName = scanner.nextLine();

        Connection connection = Utils.getSQLConnection();

        PreparedStatement queryTown = connection.prepareStatement(SET_TOWNS_TO_UPPER_CASE);

        queryTown.setString(1, countryName);

        int updatedTownsCount = queryTown.executeUpdate();

        PreparedStatement queryTownNames = connection.prepareStatement(GET_TOWN_NAMES);

        queryTownNames.setString(1, countryName);

        ResultSet townSet = queryTownNames.executeQuery();

        if (updatedTownsCount==0) {
            System.out.println(NO_TOWNS_AFFECTED);
            return;
        }

        System.out.printf(COUNT_OF_AFFECTED_TOWNS,updatedTownsCount);
        List<String> townNames =new ArrayList<>();

        while (townSet.next()){
          townNames.add(townSet.getString(Constants.COLUMN_NAME));
        }

        System.out.println(townNames);

        connection.close();
    }
}
