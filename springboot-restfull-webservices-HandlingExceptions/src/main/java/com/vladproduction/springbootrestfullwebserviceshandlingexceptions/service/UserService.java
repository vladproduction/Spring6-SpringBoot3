package com.vladproduction.springbootrestfullwebserviceshandlingexceptions.service;



import com.vladproduction.springbootrestfullwebserviceshandlingexceptions.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long userId);

}
