package com.vladproduction.springbootrestfullwebservicesdocumentationapi.service;



import com.vladproduction.springbootrestfullwebservicesdocumentationapi.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long userId);

}
