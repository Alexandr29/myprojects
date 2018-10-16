
import com.nixsolutions.service.impl.User;
import com.nixsolutions.service.jdbc.AbstractJdbcDao;
import com.nixsolutions.service.jdbc.JdbcUserDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        User user1 = new User("alex1","1234","alexru","Alex","Last");
        User user2 = new User("tolik","1234","toliku","Tolik","Last");
        AbstractJdbcDao abstractJdbcDao = new AbstractJdbcDao();
        abstractJdbcDao.createConnection();
        //abstractJdbcDao.createDatabase();
        JdbcUserDao jdbcUserDao = new JdbcUserDao();
        jdbcUserDao.create(user1);
        jdbcUserDao.create(user2);
        jdbcUserDao.findAll();
    }
}
