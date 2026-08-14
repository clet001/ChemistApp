package ng.ourChemist.controllers;

import ng.ourChemist.repositories.UserRepository;
import ng.ourChemist.services.AuthService;

public class AuthServiceController {
    private final AuthService authService;
    private final UserRepository userRepository;

    public AuthServiceController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }
}
