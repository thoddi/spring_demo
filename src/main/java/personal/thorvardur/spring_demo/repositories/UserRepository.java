package personal.thorvardur.spring_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.thorvardur.spring_demo.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Finds a single user by their username.
     * @param userName The username of the user.
     * @return Returns an optional user.
     */
    Optional<User> findByUserName(String userName);
}

