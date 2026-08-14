package ng.ourChemist.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    private String password;
    private String username;
    private String fullName;
    @Id
    private String id;
    private String name;
    private boolean isLoggedIn;


}
