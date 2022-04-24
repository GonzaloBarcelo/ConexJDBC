package icai.pract10.ConexJDBC;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import icai.pract10.ConexJDBC.model.User;
@Component
public class Database {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Database.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData() {
        jdbcTemplate.execute("INSERT INTO User(USER_NAME,PASSWORD) VALUES('Gonzalo', 'HOLAMUNDO')");
        jdbcTemplate.execute("INSERT INTO CONTACT(USER_NAME,NUMBER) VALUES('Gonzalo','695540956')");
    }
    public void insertUser(User user){

        jdbcTemplate.execute("INSERT INTO User(USER_NAME,PASSWORD) VALUES('"+user.getUserName()+"', '"+user.getPassword()+"')");
    }

    public void selectAllUsers(){
        jdbcTemplate.execute("SELECT * FROM USER");
    }




}

