package com.example.cms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cms.Entity.User;
import com.example.cms.Service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registorUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/email")
    public Optional<User> getByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }
}