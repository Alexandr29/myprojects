
import com.nixsolutions.service.impl.User;
import com.nixsolutions.service.jdbc.AbstractJdbcDao;
import com.nixsolutions.service.jdbc.JdbcUserDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        User user = new User("alex1","1234","alexru","Alex","Last");
        AbstractJdbcDao abstractJdbcDao = new AbstractJdbcDao();
        abstractJdbcDao.createConnection();
        //abstractJdbcDao.createDatabase();
        JdbcUserDao jdbcUserDao = new JdbcUserDao();
        jdbcUserDao.findAll();
    }
}
