
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
                Properties prop = new Properties();
                prop.load(input);

                String url = prop.getProperty("db.url");
                String user = prop.getProperty("db.username");
                String password = prop.getProperty("db.password");
                String driver = prop.getProperty("db.driver");

                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
