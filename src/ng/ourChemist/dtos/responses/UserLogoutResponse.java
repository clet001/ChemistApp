package ng.ourChemist.dtos.responses;

import lombok.Data;

@Data
public class UserLogoutResponse {

    private String username;
    private boolean loggedOut;

}
