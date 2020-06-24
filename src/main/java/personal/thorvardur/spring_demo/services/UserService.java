package personal.thorvardur.spring_demo.services;

import personal.thorvardur.spring_demo.models.User;

import java.util.List;

public interface UserService {

    /**
     * Returns user with given id.
     * @param id The id of the user.
     * @return A user object.
     */
    User findById(int id) throws Exception;

    /**
     * Returns all users.
     * @return A list of user objects.
     */
    List<User> findAll();
}
