package DBAppsIntroduction.Lab;



import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();

        properties.setProperty("user","root");
        properties.setProperty("password","There6was6death6@");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo",properties);

        System.out.println("Enter username");

        String username=scanner.nextLine();

        PreparedStatement query = connection.prepareStatement
                ("SELECT u.user_name, u.first_name,u.last_name,(SELECT COUNT(game_id) FROM users_games AS ug WHERE ug.user_id=u.id) AS 'count' FROM users AS u " +
                        "WHERE user_name = ?;");

        query.setString(1,username);

        ResultSet result = query.executeQuery();


            if (result.next()){
                System.out.println(result.getString("user_name")+" " + result.getString("first_name") + " " + result.getString("last_name") + " " + result.getString("count"));
            }else {
                System.out.println("No such user exists");
            }

    }
}
