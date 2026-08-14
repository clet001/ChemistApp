package ng.ourChemist.services;

import ng.ourChemist.dtos.request.RegisterRequest;
import ng.ourChemist.dtos.request.UserLoginRequest;
import ng.ourChemist.dtos.request.UserLogoutRequest;
import ng.ourChemist.dtos.responses.RegisterUserResponse;
import ng.ourChemist.dtos.responses.UserLoginResponse;
import ng.ourChemist.dtos.responses.UserLogoutResponse;
import ng.ourChemist.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static ng.ourChemist.services.AuthServiceImpl.userRepository;
import static org.junit.jupiter.api.Assertions.*;


public class AuthServicesImplTest {
    private AuthService authService;
    private UserRepository userRepository;
    private RegisterRequest request;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
        authService = new AuthServiceImpl(userRepository);
        request = new RegisterRequest();
        userRepository.deleteAll();
    }

    @Test
    public void testThatYouCanRegisterAUserSuccessfully() {
        request.setFullName("Clement N.");
        request.setUsername("Clem");
        request.setPassword("12345");

        RegisterUserResponse response = authService.registerChemist(request);

        assertEquals("Register successful for chemist", response.getMessage());
    }

    @Test
    public void testThatUserNameAlreadyExists(){
        request.setFullName("Clement N.");
        request.setUsername("Clem");
        request.setPassword("12345");
        authService.registerChemist(request);

        RegisterRequest requestTwo = new RegisterRequest();
        requestTwo.setFullName("Ade N.");
        requestTwo.setUsername("Clem");
        requestTwo.setPassword("Pass123");

        assertThrows(IllegalArgumentException.class, () -> {authService.registerChemist(requestTwo);
        });
    }




    @Test
    public void testThatYouCanRegisterMultipleUsers() {
        request.setFullName("Clement N.");
        request.setUsername("Clem");
        request.setPassword("12345");
        authService.registerChemist(request);

        RegisterRequest requestTwo = new RegisterRequest();
        requestTwo.setFullName("Ade N.");
        requestTwo.setUsername("Adde");
        requestTwo.setPassword("Pass123");
        authService.registerChemist(requestTwo);

        assertEquals(2, userRepository.count());
    }

    @Test
    public void testThatUserShouldLoginSuccessfully() {
        request.setFullName("Clement N.");
        request.setUsername("Clem");
        request.setPassword("12345");
        authService.registerChemist(request);

        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUsername("Clem");
        loginRequest.setPassword("12345");

        UserLoginResponse response = authService.login(loginRequest);

        assertEquals("Clem", response.getUsername());
    }

    @Test
    public void testThatUserLoginFailsWithWrongUsername() {
        request.setFullName("Clement N.");
        request.setUsername("Clem");
        request.setPassword("12345");
        authService.registerChemist(request);

        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUsername("WrongUser");
        loginRequest.setPassword("12345");

        assertThrows(IllegalArgumentException.class, () -> authService.login(loginRequest));
    }

    @Test
    public void testThatUserLoginFailsWithWrongPassword() {
        request.setFullName("Clement N.");
        request.setUsername("Clem");
        request.setPassword("12345");
        authService.registerChemist(request);

        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUsername("Clem");
        loginRequest.setPassword("12396");

        assertThrows(IllegalArgumentException.class, () -> authService.login(loginRequest));
    }

    @Test
    public void testThatUserShouldLogoutSuccessfully() {
        request.setFullName("Clement N.");
        request.setUsername("Clem");
        request.setPassword("12345");
        authService.registerChemist(request);

        UserLogoutRequest logoutRequest = new UserLogoutRequest();
        logoutRequest.setUsername("Clem");

        UserLogoutResponse response = authService.logout(logoutRequest);

        assertEquals("Clem", response.getUsername());
        assertTrue(response.isLoggedOut());

    }
    @Test
    public void shouldFailLogoutWhenUserDoesNotExist() {
        UserLogoutRequest logoutRequest = new UserLogoutRequest();
        logoutRequest.setUsername("UnknownUser");

        assertThrows(IllegalArgumentException.class, () -> authService.logout(logoutRequest));
    }


}



