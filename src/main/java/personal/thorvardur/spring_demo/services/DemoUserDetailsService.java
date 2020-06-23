package personal.thorvardur.spring_demo.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DemoUserDetailsService implements UserDetailsService
{
    /**
     * Returns a user with given userName.
     * @param userName Username of the user.
     * @return User information.
     * @throws UsernameNotFoundException Throws exception if no user is found with given username.
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // Let's return a hard coded user for now.
        return new User("admin", encoder.encode("admin"), new ArrayList<>());
    }
}
