package com.example.crudoperation.controller;

import com.example.crudoperation.model.MyUser;
import com.example.crudoperation.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private MyUserService userService;

    @PostMapping("/register")
    public MyUser registerUser(@RequestBody MyUser newUser) {
        // Optionally, add validation and additional processing
        return userService.saveUser(newUser);
    }
}
