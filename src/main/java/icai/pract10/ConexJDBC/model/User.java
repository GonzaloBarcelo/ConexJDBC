package icai.pract10.ConexJDBC.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;


@Data // lomok
public class User {

    @Id
    private Long id;
    private String userName;
    private String password;
    private String email;



    public User(String userName,String password){
        this.userName=userName;
        this.password=password;
    }
}