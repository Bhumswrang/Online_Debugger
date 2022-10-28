package com.user.User.controller;

import com.user.User.entity.User;
import com.user.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String home(){
        return "This is User home api";
    }

    @RequestMapping("/user/users")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @RequestMapping("/user/users/{uid}")
    public User getUserById(@PathVariable Long uid){
        return this.userService.getUserById(uid);
    }

    @RequestMapping(value = "/user/users", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @RequestMapping(value = "/user/users", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @RequestMapping(value = "/user/users/{uid}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long uid){
        return this.userService.deleteUser(uid);
    }

    @RequestMapping("/user/validate/{uid}")
    public boolean validateUserId(@PathVariable Long uid){
        return this.userService.validateUserId(uid);
    }

}
