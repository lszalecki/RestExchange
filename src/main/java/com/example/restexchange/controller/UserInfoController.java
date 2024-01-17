package com.example.restexchange.controller;

import com.example.restexchange.model.entity.User;
import com.example.restexchange.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/info")
@AllArgsConstructor
public class UserInfoController
{
    private final IUserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id)
    {
        return userService.findById(id).orElseThrow();
    }
}
