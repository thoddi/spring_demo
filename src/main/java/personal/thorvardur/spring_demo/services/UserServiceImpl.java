package personal.thorvardur.spring_demo.services;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import personal.thorvardur.spring_demo.models.User;
import personal.thorvardur.spring_demo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public User save(User user) {
        // Encode the given password.
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}
