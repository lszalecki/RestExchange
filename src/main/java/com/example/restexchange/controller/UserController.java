package com.example.restexchange.controller;

import com.example.restexchange.model.entity.User;
import com.example.restexchange.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/users")
@AllArgsConstructor
public class UserController
{
    private final IUserService userService;

    @GetMapping("/")
    public List<User> findAll()
    {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id)
    {
        return userService.findById(id).orElseThrow();
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
}
