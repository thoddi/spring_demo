package personal.thorvardur.spring_demo.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import personal.thorvardur.spring_demo.models.User;
import personal.thorvardur.spring_demo.services.UserService;

import java.util.List;

@Api("Manages user accounts.")
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
    @ApiOperation(
            value = "Get all users.",
            notes = "Returns all users.",
            response = User.class, responseContainer = "List")
    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    /**
     * Returns A single user by id.
     * @param id The id of a user.
     * @return A user object.
     */
    @ApiOperation(
            value = "Get user by Id.",
            notes = "Returns A single user by id.",
            response = User.class
    )
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
    @ApiOperation(

            value = "Add user",
            notes = "Saves a new user to the DB.",
            response = User.class
    )
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
    @ApiOperation(
            value = "Update user.",
            notes = "Updates the user with given id.",
            response = User.class
    )
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
    @ApiOperation(
            value = "Delete user.",
            notes = "Deletes the user with the given id.",
            response = boolean.class
    )
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
