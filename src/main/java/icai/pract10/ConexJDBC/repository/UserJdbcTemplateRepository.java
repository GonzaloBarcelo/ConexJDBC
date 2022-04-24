package icai.pract10.ConexJDBC.repository;

import icai.pract10.ConexJDBC.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcTemplateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM USER", Integer.class);
    }


    public int update(User user) {

        return jdbcTemplate.update("UPDATE USER SET PASSWORD = ? WHERE USER_NAME = ?", user.getPassword(), user.getUserName());
    }

    public int delete(User user) {
        return jdbcTemplate.update("DELETE USER WHERE ID = ?", user.getId());
    }






}

