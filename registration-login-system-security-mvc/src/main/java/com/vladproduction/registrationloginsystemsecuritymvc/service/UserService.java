package com.vladproduction.registrationloginsystemsecuritymvc.service;

import com.vladproduction.registrationloginsystemsecuritymvc.dto.UserDto;
import com.vladproduction.registrationloginsystemsecuritymvc.dto.UserDtoFullName;
import com.vladproduction.registrationloginsystemsecuritymvc.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    void saveUserByDto(UserDto userDto);
    void saveUserDtoFullName(UserDtoFullName userDtoFullName);
    User findUserByEmail(String email);
    List<UserDtoFullName> findAllUsers();

}
