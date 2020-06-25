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
     * @return A copy of the user.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User insert(@RequestBody User user){
        return userService.insert(user);
    }

    /**
     * Updates the user with given id.
     * @param id The id of the user.
     * @param user The updated user information.
     * @return A copy of the updated user object.
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable int id, @RequestBody User user) {
        try{
            return userService.update(id, user);
        }
        // If we catch an exception, we shall return a 404 status code.
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    /**
     * Deletes the user with the given id.
     * @param id The id of the user to delete.
     * @return True, if the deletion is successful.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable int id){
        try{
            return userService.delete(id);
        }
        // If we catch an exception, we shall return a 404 status code.
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
