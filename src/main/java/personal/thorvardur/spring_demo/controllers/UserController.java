package personal.thorvardur.spring_demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import personal.thorvardur.spring_demo.models.User;
import personal.thorvardur.spring_demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping(UserController.baseUrl)
public class UserController {
    public static final String baseUrl = "api/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns all users.
     * @return List of users.
     */
    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    /**
     * Returns A single user by id.
     * @param id The id of a user.
     * @return A user object.
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {

        try{
            return userService.findById(id);
        }
        // If we catch an exception, we shall return a 404 status code.
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    /**
     * Saves a new user to the DB.
     * @param user User information.
     * @return Http status code and a copy of the user.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }
}
