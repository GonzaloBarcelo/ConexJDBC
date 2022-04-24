package icai.pract10.ConexJDBC.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Contact {
    @Id
    private long id;

    private String name;
    private String userName;
    private Long number;

    private Contact(Long number){
        this.number = number;
    }

    public Contact(String userName, Long number){
        this.number = number;
        this.userName = userName;
    }
}
