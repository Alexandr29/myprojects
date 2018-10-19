package main.com.nixsolutions.service.dao;

import main.com.nixsolutions.service.impl.User;
import java.util.List;

public interface UserDao  {
    void create(User user);
    void update(User user);
    void remove(User user);
    List<User> findAll();
    User findByLogin(String login);
    User findByEmail(String email);
}
