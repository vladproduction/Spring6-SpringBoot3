package com.vladproduction.registrationloginsystemsecuritymvc.controller;

import com.vladproduction.registrationloginsystemsecuritymvc.dto.UserDto;
import com.vladproduction.registrationloginsystemsecuritymvc.dto.UserDtoFullName;
import com.vladproduction.registrationloginsystemsecuritymvc.entity.User;
import com.vladproduction.registrationloginsystemsecuritymvc.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AuthRestController {

    private UserService userService;

    public AuthRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PostMapping("/saveUserByDto")
    public void saveUserByDto(@RequestBody UserDto userDto){
        userService.saveUserByDto(userDto);
    }

    @PostMapping("/saveUserByDtoFullName")
    public void saveUserByDtoFullName(@RequestBody UserDtoFullName userDtoFullName){
        userService.saveUserDtoFullName(userDtoFullName);
    }
}
