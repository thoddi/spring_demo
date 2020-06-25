package personal.thorvardur.spring_demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import personal.thorvardur.spring_demo.models.User;
import personal.thorvardur.spring_demo.repositories.UserRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    public BootstrapData(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Fill the database with data.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        System.out.println("Loading users' data");

        User user = new User();
        user.setUserName("user");
        user.setPassword(encoder.encode("user"));
        user.setRoles("ROLE_USER");
        userRepository.save(user);

        System.out.println("Loaded users: " + userRepository.count());
    }
}
