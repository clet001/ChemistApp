package ng.ourChemist.repositories;

import ng.ourChemist.models.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryImplTest {

    @Test
    public void testNewRepoShouldBeEmpty() {
        UserRepository repository = new UserRepositoryImpl();
        long totalUsers = repository.count();
        assertEquals(0, totalUsers);
    }

    @Test
    public void testToSaveOneUserAndIncreaseCountToOne(){
        UserRepository repository = new UserRepositoryImpl();
        User user = new User();
        user.setId("001");
        user.setFullName("Clem");
        repository.save(user);
        long totalUsers = repository.count();
        assertEquals(1, totalUsers);
    }

    @Test
    public void testThatYouCanFindUserByID(){
        UserRepository repository = new UserRepositoryImpl();
        User user = new User();
        user.setId("001");
        user.setFullName("Clem");
        repository.save(user);
        User foundUser = repository.findById("001");
        assertNotNull(foundUser);
        assertEquals("001", foundUser.getFullName());
    }

    @Test
    public void testThatYouCanDeleteUser(){
        UserRepository repository = new UserRepositoryImpl();
        User user = new User();
        user.setId("001");
        user.setFullName("Clem");
        repository.save(user);
        repository.delete(user);
        assertNull(repository.findById("001"));
    }

    @Test
    public void testThatYouCanDeleteAllUsers(){

        UserRepository repository = new UserRepositoryImpl();

        User user1 = new User();
        user1.setId("001");
        user1.setFullName("Clem");

        User user2 = new User();
        user2.setId("002");
        user2.setFullName("John");

        repository.save(user1);
        repository.save(user2);
        assertEquals(2, repository.count());
        repository.deleteAll();
        assertEquals(0, repository.count());
    }
}

