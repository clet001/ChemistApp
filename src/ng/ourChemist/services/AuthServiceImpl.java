package ng.ourChemist.services;

import ng.ourChemist.dtos.request.RegisterRequest;
import ng.ourChemist.dtos.request.UserLoginRequest;
import ng.ourChemist.dtos.request.UserLogoutRequest;
import ng.ourChemist.dtos.responses.RegisterUserResponse;
import ng.ourChemist.dtos.responses.UserLoginResponse;
import ng.ourChemist.dtos.responses.UserLogoutResponse;
import ng.ourChemist.models.User;
import ng.ourChemist.repositories.UserRepository;
import ng.ourChemist.utils.Mapper;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserResponse registerChemist(RegisterRequest request) {
        User existingUser = userRepository.findByUsername(request.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("User Already Exists");
        }
        User user = Mapper.map(request);
        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("Register successful for chemist");
        return response;
    }

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        user.setLoggedIn(true);
        userRepository.save(user);

        UserLoginResponse response = new UserLoginResponse();
        response.setUsername(request.getUsername());
        response.setLoggedIn(true);
        return response;
    }

    @Override
    public UserLogoutResponse logout(UserLogoutRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("User not found, trying again!");
        }
        user.setLoggedIn(false);
        userRepository.save(user);

        UserLogoutResponse response = new UserLogoutResponse();
        response.setUsername(request.getUsername());
        response.setLoggedOut(true);
        return response;
    }
}