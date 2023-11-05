package com.ironhack.demosecurityjwt.controllers.impl;

import com.ironhack.demosecurityjwt.models.BlogPost;
import com.ironhack.demosecurityjwt.models.User;
import com.ironhack.demosecurityjwt.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful API for User management
 */
@RestController
@RequestMapping("/api")
public class UserController {

    /**
     * User service for accessing user data
     */
    @Autowired
    private UserServiceInterface userService;

    /**
     * Get a list of all users
     *
     * @return list of all users
     */
    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Save a new user
     *
     * @param user the user to be saved
     */
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }


    /* --------------------- PUT ----------------------*/
    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
        userService.updateUser(user, id);
    }

    /*----------------------- DELETE------------------------------ */
    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
