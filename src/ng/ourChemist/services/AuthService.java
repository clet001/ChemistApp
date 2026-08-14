package ng.ourChemist.services;

import ng.ourChemist.dtos.request.RegisterRequest;
import ng.ourChemist.dtos.request.UserLoginRequest;
import ng.ourChemist.dtos.request.UserLogoutRequest;
import ng.ourChemist.dtos.responses.RegisterUserResponse;
import ng.ourChemist.dtos.responses.UserLoginResponse;
import ng.ourChemist.dtos.responses.UserLogoutResponse;

public interface AuthService {


    RegisterUserResponse registerChemist(RegisterRequest request);
    UserLoginResponse login(UserLoginRequest request);
    UserLogoutResponse logout(UserLogoutRequest request);
}