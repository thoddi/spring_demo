package personal.thorvardur.spring_demo.services;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import personal.thorvardur.spring_demo.models.CreateUserDTO;
import personal.thorvardur.spring_demo.models.EditUserDTO;
import personal.thorvardur.spring_demo.models.User;
import personal.thorvardur.spring_demo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * Returns user with given id.
     * @param id The id of the user.
     * @return A user object.
     * @throws Exception Throws exception if no user is found.
     */
    @Override
    public User findById(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        // If no user was found, we throw an exception.
        user.orElseThrow(() -> new Exception("No user found with id: " + id));

        return user.get();
    }

    /**
     * Returns all users.
     * @return A list of user objects.
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Saves a new user to the DB.
     * @param user User information.
     * @return A copy of the saved user.
     */
    @Override
    public User insert(CreateUserDTO user) {
        return userRepository.save(user.toUserEntity());
    }

    /**
     * Updates the information of a user.
     * @param id The id of the user to update.
     * @param user New user information.
     * @return A copy of the updated user object.
     * @throws Exception Throws exception if no user is found.
     */
    @Override
    public User update(int id, EditUserDTO user) throws Exception {
            User oldUser = findById(id);

            oldUser.setUserName(user.getUserName());
            oldUser.setRoles(user.getRoles());

            return userRepository.save(oldUser);
    }

    /**
     * Deletes a user.
     * @param id The id of the user to delete.
     * @return returns a 'true' if successful.
     * @throws Exception Throws exception if no user is found.
     */
    @Override
    public boolean delete(int id) throws Exception {
        User user = findById(id);
        userRepository.delete(user);
        return true;
    }
}
