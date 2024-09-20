package com.vladproduction.registrationloginsystemsecuritydbauthentication.service;

import com.vladproduction.registrationloginsystemsecuritydbauthentication.dto.UserDto;
import com.vladproduction.registrationloginsystemsecuritydbauthentication.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();

}
