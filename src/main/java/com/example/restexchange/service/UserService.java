package com.example.restexchange.service;

import com.example.restexchange.model.entity.User;
import com.example.restexchange.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService
{
    private final UserRepository userRepository;

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user)
    {
        return userRepository.save(user);
    }
}
