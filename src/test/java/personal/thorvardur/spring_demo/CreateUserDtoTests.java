package personal.thorvardur.spring_demo;

import org.junit.jupiter.api.Test;
import personal.thorvardur.spring_demo.models.CreateUserDTO;
import personal.thorvardur.spring_demo.models.User;

public class CreateUserDtoTests {

    @Test
    void testToUserEntity(){
        CreateUserDTO user = new CreateUserDTO();
        user.setUserName("user");
        user.setPassword("pass");
        user.setRoles("role");

        User entity = user.toUserEntity();

        assert entity.getClass() == User.class;
        assert entity.getUserName() == "user";
        assert entity.getRoles() == "role";
    }
}
