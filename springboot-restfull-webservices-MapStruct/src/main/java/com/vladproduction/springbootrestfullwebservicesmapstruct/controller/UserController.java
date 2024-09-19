package com.vladproduction.springbootrestfullwebservicesmapstruct.controller;


import com.vladproduction.springbootrestfullwebservicesmapstruct.dto.UserDto;
import com.vladproduction.springbootrestfullwebservicesmapstruct.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api-map-struct/users")
public class UserController {

    private UserService userService;

    // [POST]: create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser  = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // [GET]: get User by id REST API
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
        UserDto userById = userService.getUserById(userId);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    // [GET]: get all Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // [PUT]: build update User REST API
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId,
                                           @RequestBody UserDto userDto){
        userDto.setId(userId);
        UserDto updateUserDto = userService.updateUser(userDto);
        return new ResponseEntity<>(updateUserDto, HttpStatus.OK);
    }

    // [DELETE]: build delete User REST API
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }

}
