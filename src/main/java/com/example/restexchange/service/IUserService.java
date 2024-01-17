package com.example.restexchange.service;

import com.example.restexchange.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService
{
    List<User> findAll();
    Optional<User> findById(Long id);

    User addUser(User user);
}
