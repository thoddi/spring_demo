package personal.thorvardur.spring_demo.services;

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

    @Override
    public User findById(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        // If no user was found, we throw an exception.
        user.orElseThrow(() -> new Exception("No user found with id: " + id));

        return user.get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
