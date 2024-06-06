package org.example.maxpetapi.controller;

import org.example.maxpetapi.Models.User;
import org.example.maxpetapi.Response.Response;
import org.example.maxpetapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public Response registration(@RequestBody User user) {
        return userService.register(user);
    }
    @PostMapping("/login")
    public Response login(@RequestBody User user){
        return userService.login(user);
    }

}
