package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Alex on 07/03/2017.
 */
public class JDBConnectionWrapper {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/library";

    private static final String USER = "root";
    private static final String PASS = "root";
    private static final int TIMEOUT = 5;

    private Connection connection;

    public JDBConnectionWrapper() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            createTables();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS book (\n" +
                "  id INT NOT NULL,\n" +
                "  author VARCHAR(500) NOT NULL,\n" +
                "  title VARCHAR(500) NOT NULL,\n" +
                "  publishedDate DATETIME NULL,\n" +
                "  PRIMARY KEY (id),\n" +
                "  UNIQUE INDEX id_UNIQUE (id ASC)); ";
        statement.execute(sql);
        System.out.println("Created book table");
    }

    public boolean testConnection() throws SQLException {
        return connection.isValid(TIMEOUT);
    }

    public Connection getConnection() {
        return connection;
    }

}
