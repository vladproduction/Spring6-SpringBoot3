package com.vladproduction.springbootrestfullwebservicesdto.service.impl;

import com.vladproduction.springbootrestfullwebservicesdto.dto.UserDto;
import com.vladproduction.springbootrestfullwebservicesdto.entity.User;
import com.vladproduction.springbootrestfullwebservicesdto.mapper.UserMapper;
import com.vladproduction.springbootrestfullwebservicesdto.repository.UserRepository;
import com.vladproduction.springbootrestfullwebservicesdto.service.UserService;
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
        User user = UserMapper.mapToUser(userDto);//convert UserDto into User JPA Entity
        User savedUser = userRepository.save(user); //saving User JPA Entity into DB
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser); //convert User JPA Entity into UserDto
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User userExisting = userRepository.findById(userDto.getId()).get();
        userExisting.setFirstName(userDto.getFirstName());
        userExisting.setLastName(userDto.getLastName());
        userExisting.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(userExisting);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository
                .deleteById(userId);
    }
}
