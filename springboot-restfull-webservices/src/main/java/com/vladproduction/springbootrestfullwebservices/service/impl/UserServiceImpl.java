package com.vladproduction.springbootrestfullwebservices.service.impl;

import com.vladproduction.springbootrestfullwebservices.entity.User;
import com.vladproduction.springbootrestfullwebservices.repository.UserRepository;
import com.vladproduction.springbootrestfullwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository
                .save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser
                .get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository
                .findAll();
    }

    @Override
    public User updateUser(User user) {
        User userExisting = userRepository.findById(user.getId()).get();
        userExisting.setFirstName(user.getFirstName());
        userExisting.setLastName(user.getLastName());
        userExisting.setEmail(user.getEmail());
        User updatedUser = userRepository.save(userExisting);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository
                .deleteById(userId);
    }
}
