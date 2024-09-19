package com.vladproduction.springbootrestfullwebservicesmodelmapper.service.impl;

import com.vladproduction.springbootrestfullwebservicesmodelmapper.dto.UserDto;
import com.vladproduction.springbootrestfullwebservicesmodelmapper.entity.User;
import com.vladproduction.springbootrestfullwebservicesmodelmapper.mapper.UserMapper;
import com.vladproduction.springbootrestfullwebservicesmodelmapper.repository.UserRepository;
import com.vladproduction.springbootrestfullwebservicesmodelmapper.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
//        User user = UserMapper.mapToUser(userDto);//convert UserDto into User JPA Entity
        User user = modelMapper.map(userDto, User.class);

        User savedUser = userRepository.save(user); //saving User JPA Entity into DB

//        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser); //convert User JPA Entity into UserDto
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
//        return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());
        return users.stream()
                .map((user)-> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User userExisting = userRepository.findById(userDto.getId()).get();
        userExisting.setFirstName(userDto.getFirstName());
        userExisting.setLastName(userDto.getLastName());
        userExisting.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(userExisting);
//        return UserMapper.mapToUserDto(updatedUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository
                .deleteById(userId);
    }
}
