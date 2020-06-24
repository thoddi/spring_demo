package personal.thorvardur.spring_demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import personal.thorvardur.spring_demo.models.User;
import personal.thorvardur.spring_demo.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserController.baseUrl)
public class UserController {
    public static final String baseUrl = "api/v1/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns all users.
     * @return List of users.
     */
    @GetMapping
    List<User> getAll() {
        return userService.findAll();
    }

    /**
     * Returns A single user by id.
     * @param id The id of a user.
     * @return A user object.
     */
    @GetMapping("/{id}")
    User getById(@PathVariable int id) {

        try{
            return userService.findById(id);
        }
        // If we catch an exception, we shall return a 404 status code.
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
