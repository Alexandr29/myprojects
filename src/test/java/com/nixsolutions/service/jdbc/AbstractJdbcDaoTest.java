package com.nixsolutions.service.jdbc;

import main.java.com.nixsolutions.service.impl.Role;
import main.java.com.nixsolutions.service.impl.User;
import main.java.com.nixsolutions.service.jdbc.AbstractJdbcDao;
import main.java.com.nixsolutions.service.jdbc.JdbcUserDao;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class AbstractJdbcDaoTest extends DBTestCase {
    @Override public void setUp() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("h2");
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
                resourceBundle.getString("jdbc.driver"));
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
                resourceBundle.getString("jdbc.url"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
                resourceBundle.getString("jdbc.password"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
                resourceBundle.getString("jdbc.username"));
        createTables();
        super.setUp();
    }

    private JdbcUserDao userDao = new JdbcUserDao();

    public AbstractJdbcDaoTest() {
    }

    public void testFindAll() {
        List<User> expectedList = new ArrayList<>();
        expectedList
                .add(new User(1L, "Alex", "1234", "alex@gmail.com", "Alexandr",
                        "Sinkevich", Date.valueOf("1997-04-29"), 1L));
        assertEquals(expectedList.toString(), userDao.findAll().toString());
    }

    public void testFindByLoginTest() {
        Role expectedRole = new Role(1l, "admin");
        User expectedUser = new User(1L, "Alex", "1234", "alex@gmail.com",
                "Alexandr", "Sinkevich", Date.valueOf("1997-04-29"), 1L);
        assertEquals(expectedUser.toString(),
                userDao.findByLogin("Alex").toString());
    }

    public void createTables() {
        Connection connection = AbstractJdbcDao.createConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("drop table IF EXISTS USER");
            statement.execute("drop table IF EXISTS ROLE");
            statement.execute("CREATE TABLE IF NOT EXISTS ROLE("
                    + "ROLE_ID INT(11) NOT NULL auto_increment primary key, "
                    + "ROLENAME VARCHAR);");
            statement.execute("CREATE TABLE IF NOT EXISTS USER("
                    + "USER_ID INT(11) NOT NULL auto_increment primary key, "
                    + "LOGIN VARCHAR, " + "PASSWORD VARCHAR, "
                    + "EMAIL VARCHAR, " + "FIRSTNAME VARCHAR, "
                    + "LASTNAME VARCHAR, " + "DATE DATE," + "ROLE_ID INT(11),"
                    + "FOREIGN KEY(ROLE_ID) REFERENCES ROLE(ROLE_ID));");
        } catch (SQLException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new File(
                "src/test/java/resources/testDataSet.xml"));
    }
}
