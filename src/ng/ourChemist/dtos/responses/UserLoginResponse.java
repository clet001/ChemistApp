package ng.ourChemist.dtos.responses;

import lombok.Data;

@Data
public class UserLoginResponse {
    private String username;
    private boolean loggedIn;

}
