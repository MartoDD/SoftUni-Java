package Exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _7_PrintAllMinionNames {
    public static void main(String[] args) throws SQLException {

        final String GET_ALL_MINION_NAMES="SELECT name FROM minions";

        Connection connection = Utils.getSQLConnection();

        PreparedStatement getAllMinionNames=connection.prepareStatement(GET_ALL_MINION_NAMES);
        ResultSet allMinionNamesSet=getAllMinionNames.executeQuery();
        List<String> minionNames=new ArrayList<>();

        while (allMinionNamesSet.next()){
            minionNames.add(allMinionNamesSet.getString(Constants.COLUMN_NAME));
        }

        for (int i = 0; i < minionNames.size()/2; i++) {

            System.out.println(minionNames.get(i));
            System.out.println(minionNames.get(minionNames.size()-1-i));
        }
    }
}
