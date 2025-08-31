package com.example.creditWiseapi.controller;

import com.example.creditWiseapi.entity.User;
import com.example.creditWiseapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService clientService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user ){
        return clientService.createUser(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByName(@RequestBody User user){
        return clientService.getUserByName(user.getName());
    }
}
