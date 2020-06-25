package personal.thorvardur.spring_demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import personal.thorvardur.spring_demo.models.EditUserDTO;
import personal.thorvardur.spring_demo.models.User;
import personal.thorvardur.spring_demo.repositories.UserRepository;
import personal.thorvardur.spring_demo.services.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;

public class UserServiceTests {

    @InjectMocks
    UserServiceImpl service;

    @Mock
    UserRepository userRepository;

    private List<User> testUsers;

    public UserServiceTests(){
        testUsers = new ArrayList<>();
        testUsers.add(new User("User1", "pass1", "role1"));
        testUsers.add(new User("User2", "pass2", "role1,role2"));
        testUsers.add(new User("User3", "pass3", "role1"));
    }

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void testFindAllEmpty() throws Exception {
        Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>());

        List<User> users = service.findAll();

        assert users.isEmpty();
    }

    @Test
    final void testFindAll() throws Exception {
        Mockito.when(userRepository.findAll()).thenReturn(testUsers);

        List<User> users = service.findAll();

        assert users.size() == 3;
    }

    @Test
    final void testFindById() throws Exception {
        Mockito.when(userRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(testUsers.get(1)));

        User user = service.findById(2);

        assert user == testUsers.get(1);
    }

    @Test
    final void testFindByIdEmpty() throws Exception {
        Mockito.when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        try {
            service.findById(2);
        }
        catch (Exception e){
            assert e.getMessage().equals("No user found with id: 2");
        }
    }

    @Test
    final void testUpdateEmpty(){
        Mockito.when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        try {
            service.update(1, new EditUserDTO());
        }
        catch (Exception e){
            assert e.getMessage().equals("No user found with id: 1");
        }
    }

    @Test
    final void testDeleteEmpty(){
        Mockito.when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        try {
            service.delete(1);
        }
        catch (Exception e){
            assert e.getMessage().equals("No user found with id: 1");
        }
    }
}
