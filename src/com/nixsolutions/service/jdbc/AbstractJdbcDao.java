package com.nixsolutions.service.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AbstractJdbcDao {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("h2");
    private String driver = resourceBundle.getString("jdbc.driver");
    private String url = resourceBundle.getString("jdbc.url");
    private String username = resourceBundle.getString("jdbc.username");
    private String password = resourceBundle.getString("jdbc.password");

    private Connection connection;

    public Connection createConnection() throws ClassNotFoundException {
        try {
            Class.forName(driver);
            connection = DriverManager
                    .getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void createDatabase() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("drop table USER");
        statement.execute("drop table ROLE");
        statement.execute("CREATE TABLE ROLE("
                + "ROLE_ID INT(11) NOT NULL auto_increment primary key, "
                + "ROLENAME VARCHAR);");
        statement.execute("CREATE TABLE USER("
                + "USER_ID INT(11) NOT NULL auto_increment primary key, "
                + "LOGIN VARCHAR, " + "PASSWORD VARCHAR, " + "EMAIL VARCHAR, "
                + "FIRSTNAME VARCHAR, " + "LASTNAME VARCHAR, " + "DATE DATE,"
                + "ROLE_ID INT(11),"
                + "FOREIGN KEY(ROLE_ID) REFERENCES ROLE(ROLE_ID));");

    }
}
