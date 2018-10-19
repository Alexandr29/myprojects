package main.java.com.nixsolutions.service.dao;

import main.java.com.nixsolutions.service.impl.Role;

public interface RoleDao {
    void create(Role role);
    void update(Role role);
    void remove(Role role);
    Role findByName(String name);
}
