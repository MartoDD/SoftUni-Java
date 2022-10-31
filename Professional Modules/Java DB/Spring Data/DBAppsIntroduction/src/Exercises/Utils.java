package DBAppsIntroduction.Exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

enum Utils {
    ;

    static Connection getSQLConnection() throws SQLException {


        Properties properties = new Properties();

        properties.setProperty(Constants.USER,"root");
        properties.setProperty(Constants.PASSWORD,"krastavici");

        return DriverManager.getConnection(Constants.DB_URL,properties);
    }
}
