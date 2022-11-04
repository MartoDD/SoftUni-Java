package Exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class _4_AddMinion {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final String IS_THE_TOWN_PRESENT="SELECT name FROM towns WHERE name=?";
        final String IS_THE_VILLAIN_PRESENT="SELECT name FROM villains WHERE name=?";

        final String ADD_TOWN = "INSERT INTO towns (name)VALUE (?)";
        final String ADD_VILLAIN = "INSERT INTO villains (name,evilness_factor) VALUE (?,'evil')";
        final String ADD_MINION_IN_MINIONS="INSERT INTO minions(name,age,town_id) VALUES (?,?,(SELECT id FROM towns WHERE name=?));";
        final String ADD_MINION_IN_MINIONS_VILLAINS="INSERT INTO minions_villains(minion_id, villain_id) VALUES(?,(SELECT id FROM villains WHERE  name=?));";
        final String LAST_MINION_ADDED_ID="SELECT id FROM minions ORDER BY id DESC LIMIT 1";

        final String TOWN_ADDED="Town %s was added to the database.%n";
        final String VILLAIN_ADDED="Villain %s was added to the database.%n";
        final String MINION_ADDED_TO_VILLAIN="Successfully added %s to be minion of %s.";

        String [] minionInformation=scanner.nextLine().split(" ");

        String minionName=minionInformation[1];
        int minionAge=Integer.parseInt(minionInformation[2]);
        String townName=minionInformation[3];
        String villainName=scanner.nextLine().split(" ")[1];

        Connection connection = Utils.getSQLConnection();

        addVillainTownIfNotPresent(IS_THE_TOWN_PRESENT, ADD_TOWN, TOWN_ADDED, townName, connection);

        addVillainTownIfNotPresent(IS_THE_VILLAIN_PRESENT, ADD_VILLAIN, VILLAIN_ADDED, villainName, connection);

        PreparedStatement addMinionInMinions=connection.prepareStatement(ADD_MINION_IN_MINIONS);
        addMinionInMinions.setString(1,minionName);
        addMinionInMinions.setInt(2,minionAge);
        addMinionInMinions.setString(3,townName);
        addMinionInMinions.executeUpdate();

        PreparedStatement lastMinionAddedId=connection.prepareStatement(LAST_MINION_ADDED_ID);
        ResultSet lastMinionAddedIdSet=lastMinionAddedId.executeQuery();
        lastMinionAddedIdSet.next();
        int lastAddedMinionId=lastMinionAddedIdSet.getInt("id");

        PreparedStatement addMinionInMinionsVillains=connection.prepareStatement(ADD_MINION_IN_MINIONS_VILLAINS);
        addMinionInMinionsVillains.setInt(1,lastAddedMinionId);
        addMinionInMinionsVillains.setString(2,villainName);

        addMinionInMinionsVillains.executeUpdate();

        System.out.printf(MINION_ADDED_TO_VILLAIN,minionName,villainName);
    }

    private static void addVillainTownIfNotPresent(String isVillainTownPresent, String villainTown, String villainTownAdded, String name, Connection connection) throws SQLException {
        PreparedStatement isVillainOrTownPresent=connection.prepareStatement(isVillainTownPresent);
        isVillainOrTownPresent.setString(1,name);
        ResultSet isVillainTownPresentEntry=isVillainOrTownPresent.executeQuery();

        if (!isVillainTownPresentEntry.next()){
            PreparedStatement insertVillainTown=connection.prepareStatement(villainTown);
            insertVillainTown.setString(1,name);
            insertVillainTown.executeUpdate();
            System.out.printf(villainTownAdded,name);
        }
    }
}
