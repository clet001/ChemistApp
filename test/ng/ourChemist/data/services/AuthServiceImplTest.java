//package ng.ourChemist.data.services;
//
//import ng.ourChemist.dtos.request.RegisterRequest;
//import ng.ourChemist.repositories.UserRepository;
//import ng.ourChemist.repositories.UserRepositoryImpl;
//import ng.ourChemist.services.AuthService;
//import ng.ourChemist.services.AuthServiceImpl;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class AuthServiceImplTest {
//
//    @Test
//    public void testToRegisterOneChemistAndReceiveSuccessResponse() {
//        UserRepository repository = new UserRepositoryImpl();
//        AuthService service = new AuthServiceImpl(repository);
//
//        RegisterRequest request = new RegisterRequest();
//        request.setUsername("Clem");
//        request.setPassword("pass12345");
//        request.setFullName("Clement Chinedu");
//
//        service.registerChemist(request);
//        assertEquals(1, repository.count());
//    }
//
//    @Test
//    public void testToRegisterTwoChemistAndReceiveSuccessResponse(){
//        UserRepository repository = new UserRepositoryImpl();
//        AuthService service = new AuthServiceImpl();
//
//        RegisterRequest request = new RegisterRequest();
//        request.setUsername("Clem");
//        request.setPassword("pass12345");
//        request.setFullName("Clement Chinedu");
//        service.registerChemist(request);
//
//        RegisterRequest requestTwo = new RegisterRequest();
//        request.setUsername("Ade");
//        request.setPassword("Wsass12345");
//        request.setFullName("Ade Olu");
//        service.registerChemist(request);
//
//    }
//
//}
//
//
