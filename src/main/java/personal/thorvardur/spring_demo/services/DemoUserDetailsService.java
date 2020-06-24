package personal.thorvardur.spring_demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import personal.thorvardur.spring_demo.models.DemoUserDetails;
import personal.thorvardur.spring_demo.models.User;
import personal.thorvardur.spring_demo.repositories.UserRepository;

import java.util.Optional;

@Service
public class DemoUserDetailsService implements UserDetailsService
{
    @Autowired
    UserRepository userRepository;

    /**
     * Returns a user with given userName.
     * @param userName Username of the user.
     * @return User information.
     * @throws UsernameNotFoundException Throws exception if no user is found with given username.
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        // If no user is found an exception is thrown.
        user.orElseThrow(() -> new UsernameNotFoundException("No user found with name: " + userName));

        return user.map(DemoUserDetails::new).get();
    }
}
