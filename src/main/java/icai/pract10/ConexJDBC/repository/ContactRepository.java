package icai.pract10.ConexJDBC.repository;

import icai.pract10.ConexJDBC.model.Contact;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    //Join
    @Query("SELECT * FROM CONTACT INNER JOIN USER ON USER.ID=CONTACT.ID")
    List<Contact> getContactsByID();
}
