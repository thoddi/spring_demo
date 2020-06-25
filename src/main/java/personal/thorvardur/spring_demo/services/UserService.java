package personal.thorvardur.spring_demo.services;

import personal.thorvardur.spring_demo.models.CreateUserDTO;
import personal.thorvardur.spring_demo.models.EditUserDTO;
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

    /**
     * Saves a new user to the DB.
     * @param user User information.
     * @return A copy of the saved user.
     */
    User insert(CreateUserDTO user);

    /**
     * Updates the information of a user.
     * @param id The id of the user to update.
     * @param user New user information.
     * @return A copy of the updated user object.
     * @throws Exception Throws exception if no user is found.
     */
    User update(int id, EditUserDTO user) throws Exception;

    /**
     * Deletes a user.
     * @param id The id of the user to delete.
     * @return returns a 'true' if successful.
     * @throws Exception Throws exception if no user is found.
     */
    boolean delete(int id) throws Exception;
}
