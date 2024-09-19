package com.vladproduction.springbootrestfullwebservicesdto.service;

import com.vladproduction.springbootrestfullwebservicesdto.dto.UserDto;
import com.vladproduction.springbootrestfullwebservicesdto.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long userId);

}
