package com.nixsolutions.service.jdbc;

import com.nixsolutions.service.dao.UserDao;
import com.nixsolutions.service.impl.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao extends AbstractJdbcDao implements UserDao {
    private List<User> users = new ArrayList<>();

    @Override public void create(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String login = user.getLogin();
        String password = user.getPassword();
        String email = user.getEmail();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        String insertTableSQL = "INSERT INTO USER"
                + "(LOGIN, PASSWORD, EMAIL, FIRSTNAME, LASTNAME) VALUES"
                + "(?,?,?,?,?)";
        try {

            connection = createConnection();
            preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, firstName);
            preparedStatement.setString(5, lastName);

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override public void update(User user) {

    }

    @Override public void remove(User user) {

    }

    @Override public List<User> findAll() {
        User user;
        Connection connection;
        Statement statement;

        try {
            connection = createConnection();
            statement = connection.createStatement();
            String s = "Select * From USER";
            ResultSet rst;
            rst = statement.executeQuery(s);
            while (rst.next()) {
                user = new User(rst.getString("LOGIN"),
                        rst.getString("PASSWORD"), rst.getString("EMAIL"),
                        rst.getString("FIRSTNAME"), rst.getString("LASTNAME"));
                users.add(user);
            }
            System.out.println(users.toString());
        } catch (Exception e) {
            System.out.println("exeption" + e.getCause());
        }
        return users;
    }

    @Override public User findByLogin(String login) {
        return null;
    }

    @Override public User findByEmail(String email) {
        return null;
    }
}
