package ng.ourChemist.utils;

import ng.ourChemist.dtos.request.AddDrugRequest;
import ng.ourChemist.dtos.request.RegisterRequest;
import ng.ourChemist.dtos.request.UserLoginRequest;
import ng.ourChemist.dtos.responses.UserLoginResponse;
import ng.ourChemist.models.Drug;
import ng.ourChemist.models.User;

public class Mapper {

    public static User map(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }

    public static Drug map(AddDrugRequest request){

    }
}
