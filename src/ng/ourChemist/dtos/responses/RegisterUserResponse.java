package ng.ourChemist.dtos.responses;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String fullName;
    private String userName;
    private String message;

}

