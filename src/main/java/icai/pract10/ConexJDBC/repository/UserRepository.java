package icai.pract10.ConexJDBC.repository;
import icai.pract10.ConexJDBC.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //List<User> findByFirstName(String firstName);

    @Modifying
    @Query("UPDATE USER SET USER_NAME = :USER_NAME WHERE id = :id")
    boolean updateByIdTheUserName(@Param("id") Long id, @Param("USER_NAME") String name);

   //Selecting all users
    @Query("SELECT * FROM USER")
    List<User> selectAllUser();

}