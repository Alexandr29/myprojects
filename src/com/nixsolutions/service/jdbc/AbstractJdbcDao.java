package com.nixsolutions.service.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractJdbcDao {
    private Connection connection;
// String login, String password, String email,
//            String firstName, String lastName
    public Connection createConnection() throws ClassNotFoundException {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/USER", "test", "test");
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void createDatabase() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE USER("
                + "USER_ID INT(11) NOT NULL auto_increment, "
                + "LOGIN VARCHAR, "
                + "PASSWORD VARCHAR, "
                + "EMAIL VARCHAR, "
                + "FIRSTNAME VARCHAR, "
                + "LASTNAME VARCHAR);");
    }
}
