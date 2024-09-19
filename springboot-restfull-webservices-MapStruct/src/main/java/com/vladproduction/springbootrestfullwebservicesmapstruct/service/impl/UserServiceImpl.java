package com.vladproduction.springbootrestfullwebservicesmapstruct.service.impl;


import com.vladproduction.springbootrestfullwebservicesmapstruct.dto.UserDto;
import com.vladproduction.springbootrestfullwebservicesmapstruct.entity.User;
import com.vladproduction.springbootrestfullwebservicesmapstruct.mapper.AutoUserMapper;
import com.vladproduction.springbootrestfullwebservicesmapstruct.mapper.UserMapper;
import com.vladproduction.springbootrestfullwebservicesmapstruct.repository.UserRepository;
import com.vladproduction.springbootrestfullwebservicesmapstruct.service.UserService;
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
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
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
        User userExisting = userRepository.findById(userDto.getId()).get();
        userExisting.setFirstName(userDto.getFirstName());
        userExisting.setLastName(userDto.getLastName());
        userExisting.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(userExisting);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository
                .deleteById(userId);
    }
}
