package personal.thorvardur.spring_demo;

import org.junit.jupiter.api.Test;
import personal.thorvardur.spring_demo.models.EditUserDTO;
import personal.thorvardur.spring_demo.models.User;

public class EditUserDtoTests {

    @Test
    void testApplyTo(){
        User user = new User();
        user.setUserName("user1");
        user.setPassword("pass");
        user.setRoles("role1");
        user.setId(1);

        EditUserDTO editUser = new EditUserDTO();
        editUser.setUserName("user2");
        editUser.setRoles("role2");

        editUser.applyTo(user);

        assert user.getUserName().equals("user2");
        assert user.getRoles().equals("role2");
        assert user.getId() == 1;
    }
}
