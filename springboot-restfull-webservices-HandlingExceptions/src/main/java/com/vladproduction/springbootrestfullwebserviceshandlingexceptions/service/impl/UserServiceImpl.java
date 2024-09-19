package com.vladproduction.springbootrestfullwebserviceshandlingexceptions.service.impl;


import com.vladproduction.springbootrestfullwebserviceshandlingexceptions.dto.UserDto;
import com.vladproduction.springbootrestfullwebserviceshandlingexceptions.entity.User;
import com.vladproduction.springbootrestfullwebserviceshandlingexceptions.exception.EmailAlreadyExistException;
import com.vladproduction.springbootrestfullwebserviceshandlingexceptions.exception.ResourceNotFoundException;
import com.vladproduction.springbootrestfullwebserviceshandlingexceptions.mapper.AutoUserMapper;
import com.vladproduction.springbootrestfullwebserviceshandlingexceptions.repository.UserRepository;
import com.vladproduction.springbootrestfullwebserviceshandlingexceptions.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()) {
            throw new EmailAlreadyExistException("Email already exist, use other email.");
        }
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(AutoUserMapper.MAPPER::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User userExisting = userRepository.findById(userDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userDto.getId())
        );
        userExisting.setFirstName(userDto.getFirstName());
        userExisting.setLastName(userDto.getLastName());
        userExisting.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(userExisting);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User userExisting = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        userRepository
                .deleteById(userId);
    }
}
